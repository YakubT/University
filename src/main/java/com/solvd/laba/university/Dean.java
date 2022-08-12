package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.IncorrectStudentDataException;
import com.solvd.laba.university.interfaces.IMakingRating;
import com.solvd.laba.university.interfaces.IMakingReport;

import java.util.*;
import java.util.stream.Collectors;

public class Dean extends WorkerOfFaculty implements IMakingReport, IMakingRating {
    public Dean() {

    }

    public Dean(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Dean(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }
    public void checker(List<Student> studentList){
        if (studentList.stream().anyMatch(Objects::isNull))
            throw new IncorrectStudentDataException("Instance of Student is null");
        if (studentList.stream().anyMatch(student -> student.getNameOfUniversity()==null))
            throw new IncorrectStudentDataException("The university isn't indicated");
    }

    //input - all students of the university or all students of the faculty
    @Override
    public String makeReport(List<Student> studentList)  {
        checker(studentList);
        int cnt = (int) studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getFaculty().equals(getFaculty())).count();
        String s = "There are "+cnt+" students of "+this.getFaculty().toString();
        HashMap<EducationalProgram,Integer> cntOfStudentsOfEduProgram = new HashMap<EducationalProgram,Integer>();
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getFaculty().equals(getFaculty())).forEach(student -> {
                    int c = 0;
                    if (cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram())!=null)
                        c = cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram())+1;
                    else
                        c=1;
                    cntOfStudentsOfEduProgram.put(student.getStudentCard().getEduProgram(),c);
        });
        for (Map.Entry<EducationalProgram,Integer> entry:cntOfStudentsOfEduProgram.entrySet()) {
            s+="\n"+"There are "+entry.getValue()+" students of "+entry.getKey().getDescription();
        }
        return  s;
    }

    //date - start day of setting marking for the session
    @Override
    public String makeRating(List<Student> studentList,Date date) {
        checker(studentList);
        List<Student> rating = studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getFaculty().equals(getFaculty())).
                collect(Collectors.toList()).stream().sorted(Comparator.comparing(Student::getCourseOfStudy).
                        thenComparing(Student::getSpecialty).thenComparing(student -> -student.calculateRatingScore(date))).
                collect(Collectors.toList());
        String s = "Rating students of "+getFaculty().toString();
        s+="\n"+rating.get(0).getCourseOfStudy()+" course";
        s+="\nspecialty: "+rating.get(0).getSpecialty();
        s+="\n"+rating.get(0).toString()+" "+rating.get(0).calculateRatingScore(date);
        for (int i=1;i<rating.size();i++) {
            if (rating.get(i).getCourseOfStudy()!=rating.get(i-1).getCourseOfStudy()) {
                s += "\n" + rating.get(i).getCourseOfStudy();
                s+="\n"+rating.get(i).getSpecialty();
            } else if (rating.get(i).getSpecialty()!=rating.get(i-1).getSpecialty())
                s+="\n"+rating.get(i).getSpecialty();
            s+="\n"+rating.get(i).toString()+" "+rating.get(i).calculateRatingScore(date);
        }
        return s;
    }
}
