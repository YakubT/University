package com.solvd.university;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.HashMap;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.enums.Gender;
import com.solvd.university.exceptions.IncorrectStudentDataException;
import com.solvd.university.interfaces.ICalculatingRatingScore;
import com.solvd.university.interfaces.IMakingRating;
import com.solvd.university.interfaces.IMakingReport;

public class Dean extends WorkerOfFaculty implements IMakingReport, IMakingRating {

    private static final Logger LOGGER = LogManager.getLogger(Dean.class.getName());

    public Dean() {

    }

    public Dean(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Dean(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }

    public void checker(List<Student> studentList){
        if (studentList.stream().anyMatch(Objects::isNull)) {
            throw new IncorrectStudentDataException("Instance of Student is null");
        }
        if (studentList.stream().anyMatch(student -> student.getNameOfUniversity()==null)) {
            throw new IncorrectStudentDataException("The university isn't indicated");
        }
    }

    //input - all students of the university or all students of the faculty
    @Override
    public void makeReport(List<Student> studentList)  {
        checker(studentList);
        int cnt = (int) studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getFaculty().equals(getFaculty())).count();
        LOGGER.info("There are "+cnt+" students of "+this.getFaculty().toString()+"\n");
        HashMap<EducationalProgram,Integer> cntOfStudentsOfEduProgram = new HashMap<EducationalProgram,Integer>();
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())).filter(
                student-> student.getStudentCard().getFaculty().equals(getFaculty())).forEach(student -> {
                    int c = 0;
                    if (cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram())!=null) {
                        c = cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram()) + 1;
                    }
                    else {
                        c = 1;
                    }
                    cntOfStudentsOfEduProgram.put(student.getStudentCard().getEduProgram(),c);
        });
        cntOfStudentsOfEduProgram.forEach((key, value) -> LOGGER.info("There are " + value + " students of " + key.toString()+"\n"));
    }

    //date - start day of setting marking for the session
    @Override
    public void makeRating(List<Student> studentList, Date date, ICalculatingRatingScore calc) {
        checker(studentList);
        List<Student> rating = studentList.stream().filter(student -> student.getNameOfUniversity()
                .equals(getNameOfUniversity())).filter(student->student.getStudentCard().getFaculty().equals(getFaculty()))
                .filter(student -> student.calculateRatingScore(calc,date)!=0).
                collect(Collectors.toList()).stream().sorted(Comparator.comparing(Student::getCourseOfStudy).
                        thenComparing(Student::getSpecialty).thenComparing(student -> -student.calculateRatingScore(calc,date))).
                collect(Collectors.toList());
        LOGGER.info("Rating students of "+getFaculty().toString()+" of "+getNameOfUniversity()+" university\n");
        LOGGER.info(rating.get(0).getCourseOfStudy()+" course\n");
        LOGGER.info("specialty: "+rating.get(0).getSpecialty()+"\n");
        LOGGER.info(rating.get(0).toString()+" "+rating.get(0).calculateRatingScore(calc,date)+"\n");
        for (int i=1;i<rating.size();i++) {
            if (rating.get(i).getCourseOfStudy()!=rating.get(i-1).getCourseOfStudy()) {
                 LOGGER.info(rating.get(i).getCourseOfStudy()+" course\n");
                LOGGER.info(rating.get(i).getSpecialty()+"\n");
            } else if (rating.get(i).getSpecialty()!=rating.get(i-1).getSpecialty()) {
                LOGGER.info(rating.get(i).getSpecialty()+"\n");
            }
            LOGGER.info(rating.get(i).toString()+" "+rating.get(i).calculateRatingScore(calc,date)+"\n");
        }
    }
}
