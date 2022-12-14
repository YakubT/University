package com.solvd;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.Dean;
import com.solvd.university.Department;
import com.solvd.university.EducationalProgram;
import com.solvd.university.Faculty;
import com.solvd.university.GradeBookField;
import com.solvd.university.HeadOfDepartment;
import com.solvd.university.Rector;
import com.solvd.university.Student;
import com.solvd.university.StudentCard;
import com.solvd.university.WorkerOfFaculty;
import com.solvd.university.enums.Gender;
import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.SocialSupport;
import com.solvd.university.interfaces.ICalculatingRatingScore;
import com.solvd.university.interfaces.IMakingScolarshipList;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ArrayList<String> universityList = new ArrayList<String>();
        ArrayList<Rector> rectorList = new ArrayList<Rector>();
        int id = 0;
        for (int i = 0; i < 3; i++) {
            universityList.add(RandomGeneration.getRandomString().toUpperCase());
            rectorList.add(new Rector());
            rectorList.get(i).setSurname(RandomGeneration.getRandomSurnameOrName());
            rectorList.get(i).setName(RandomGeneration.getRandomSurnameOrName());
            rectorList.get(i).setNameOfUniversity(universityList.get(i));
            rectorList.get(i).setGender(RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE);
            rectorList.get(i).setId(String.valueOf(id++));
        }
        Faculty[] facultyArr = new Faculty[RandomUtils.nextInt(10, 50)];
        int startIdOfEduProgram = 0;
        Dean[] deanArr = new Dean[facultyArr.length];
        List<HeadOfDepartment> headOfDepartmentList = new ArrayList<HeadOfDepartment>();
        for (int i = 0; i < facultyArr.length; i++) {
            facultyArr[i] = new Faculty(RandomGeneration.getNameOfSubDivision());
            facultyArr[i].setNameOfUniversity(universityList.get(RandomUtils.nextInt(0, universityList.size())));
            ArrayList<Department> departmentList = new ArrayList<Department>();
            int sizeDep = RandomUtils.nextInt(2, 5);
            for (int j = 0; j < sizeDep; j++) {
                ArrayList<EducationalProgram> educationalPrograms = new ArrayList<EducationalProgram>();
                int sizeEd = RandomUtils.nextInt(1, 3);
                for (int o = 0; o < sizeEd; o++)
                    educationalPrograms.add(new EducationalProgram(RandomUtils.nextInt(100, 200),
                            startIdOfEduProgram++, RandomGeneration.getRandomString()));
                departmentList.add(new Department(RandomGeneration.getNameOfSubDivision(), educationalPrograms));
                HeadOfDepartment hD = new HeadOfDepartment();
                hD.setFaculty(facultyArr[i]);
                hD.setDepartment(departmentList.get(j));
                hD.setNameOfUniversity(facultyArr[i].getNameOfUniversity());
                hD.setGender(RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE);
                hD.setId(String.valueOf(id++));
                headOfDepartmentList.add(hD);
            }
            facultyArr[i].setListOfDepartments(departmentList);

            deanArr[i] = new Dean();
            deanArr[i].setFaculty(facultyArr[i]);
            deanArr[i].setNameOfUniversity(facultyArr[i].getNameOfUniversity());
            deanArr[i].setName(RandomGeneration.getRandomSurnameOrName());
            deanArr[i].setSurname(RandomGeneration.getRandomSurnameOrName());
            deanArr[i].setGender(RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE);
            deanArr[i].setId(String.valueOf(id++));
        }
        List<Student> studentList = new ArrayList<Student>();
        List<WorkerOfFaculty> teacherList = new ArrayList<WorkerOfFaculty>();
        int cntTeacher = RandomUtils.nextInt(100, 1000);
        for (int i = 0; i < cntTeacher; i++) {
            teacherList.add(new WorkerOfFaculty());
            teacherList.get(i).setName(RandomGeneration.getRandomSurnameOrName());
            teacherList.get(i).setSurname(RandomGeneration.getRandomSurnameOrName());
            teacherList.get(i).setFaculty(RandomGeneration.getRandomElementFromArray(facultyArr));
            Faculty faculty = teacherList.get(i).getFaculty();
            teacherList.get(i).setDepartment(RandomGeneration.getRandomElementFromList(faculty.getListOfDepartments()));
            teacherList.get(i).setNameOfUniversity(faculty.getNameOfUniversity());
            teacherList.get(i).setId(String.valueOf(id++));
            teacherList.get(i).setGender(RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE);
        }
        int cntStudents = RandomUtils.nextInt(1000, 10000);
        int idStCard = 0;
        for (int i = 0; i < cntStudents; i++) {
            Student student = new Student();
            student.setName(RandomGeneration.getRandomSurnameOrName());
            student.setSurname(RandomGeneration.getRandomSurnameOrName());
            student.setId(String.valueOf(id++));
            student.setGender(RandomUtils.nextBoolean() ? Gender.MALE : Gender.FEMALE);
            StudentCard studentCard = new StudentCard();
            studentCard.setStudentCardId(String.valueOf(idStCard++));
            studentCard.setStartYearOfStudy(2021 - RandomUtils.nextInt(0, 5));
            studentCard.setGroup(RandomGeneration.getNameOfSubDivision(3) + StringUtils.substring(
                    String.valueOf(studentCard.getCourseOfStudy()), String.valueOf(studentCard.getCourseOfStudy()).
                            length() - 1));
            studentCard.setFaculty(RandomGeneration.getRandomElementFromArray(facultyArr));
            studentCard.setDepartment(RandomGeneration.getRandomElementFromList(studentCard.getFaculty().
                    getListOfDepartments()));
            studentCard.setEduProgram(RandomGeneration.getRandomElementFromList(studentCard.getDepartment().
                    getListOfEduPrograms()));
            student.setStudentCard(studentCard);
            student.setEducationalDegree(studentCard.getCourseOfStudy() > 4 ? EducationalDegree.MASTER : EducationalDegree.BACHELOR);
            List<GradeBookField> gradeBook = new ArrayList<GradeBookField>();
            for (int j = 0; j < 100; j++) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, LocalDate.now().getYear() - RandomUtils.nextInt(0, student.getCourseOfStudy()));
                calendar.set(Calendar.MONTH, RandomUtils.nextBoolean() ? 1 : 7);
                calendar.set(Calendar.DATE, RandomUtils.nextInt(1, 5));
                gradeBook.add(new GradeBookField(RandomGeneration.getRandomElementFromList(teacherList),
                        RandomGeneration.getRandomString(), RandomUtils.nextInt(60, 100), calendar.getTime()));
            }
            student.setGradeBook(gradeBook);
            student.setNameOfUniversity(student.getStudentCard().getFaculty().getNameOfUniversity());
            student.setAdditionalPoints(RandomUtils.nextInt(0, 101));
            if (RandomUtils.nextInt(0, 100) > 70) {
                int rnd = RandomUtils.nextInt(1, SocialSupport.values().length);
                student.setSocialSupport(SocialSupport.values()[rnd]);
            } else {
                student.setSocialSupport(SocialSupport.NONE);
            }
            studentList.add(student);
        }
        for (int i = 0; i < 3; i++) {
            rectorList.get(i).makeReport(studentList);
        }
        LOGGER.info("dean of " + deanArr[0].getFaculty() + " " + deanArr[0].getNameOfUniversity());
        deanArr[0].makeReport(studentList);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE, 1);
        ICalculatingRatingScore calculationFunction = (gradeBook, additionalPoint, date) -> {
            int cnt = (int) gradeBook.stream().filter(gradeBookField -> gradeBookField.getDate().compareTo(date) >= 0).count();
            double sum = 0;
            for (GradeBookField el : gradeBook) {
                if (el.getDate().compareTo(date) >= 0)
                    sum += el.getScore();
            }

            return (Math.min(Math.round((sum / cnt * 0.95 + additionalPoint * 0.05) * 100) / 100.0, 100));
        };
        deanArr[0].makeRating(studentList, calendar.getTime(), calculationFunction);
        IMakingScolarshipList iMakingScolarshipList = (studentList1, faculty, course, specialty) -> {
            List<Student> academicList = studentList1.stream().filter(student -> student.getStudentCard().getFaculty().equals(faculty)).
                    filter(student -> student.getStudentCard().getCourseOfStudy() == course).filter(student ->
                            student.getSpecialty() == specialty).sorted(Comparator.comparing(student -> student.
                            calculateRatingScore(calculationFunction, calendar.getTime()))).limit((int) Math.floor(0.4 *
                            studentList1.size())).collect(Collectors.toList());
            List<Student> socialScolarship = studentList1.stream().filter(student -> student.getStudentCard().getFaculty().equals(faculty)).
                    filter(student -> student.getStudentCard().getCourseOfStudy() == course).filter(student ->
                            student.getSpecialty() == specialty).filter(student -> !student.getSocialSupport().getValue().
                            equals("none")).collect(Collectors.toList());
            Set<Pair<Student, Integer>> res = new HashSet<Pair<Student, Integer>>();
            int cntHighScholarship = (int) Math.floor(0.25 * academicList.size());
            for (int i = 0; i < academicList.size(); i++) {
                res.add(Pair.of(academicList.get(i), i < cntHighScholarship ? 2910 : 2000));
            }
            for (Student student : socialScolarship) {
                int sum = 0;
                switch (student.getSocialSupport().getValue()) {
                    case "quota1":
                        sum = 3000;
                        break;
                    case "quota2":
                        sum = 1600;
                        break;
                }
                res.add(Pair.of(student, sum));
            }
            return res.stream().sorted(Comparator.comparing(
                    pair -> -pair.getRight())).collect(Collectors.toList());
        };
        List<Pair<Student, Integer>> scolarshipList = iMakingScolarshipList.createScolarshipList(studentList, facultyArr[0],
                1, facultyArr[0].getListOfSpecialties().get(0));
        LOGGER.info(facultyArr[0].toString() + "\n");
        LOGGER.info(facultyArr[0].getListOfSpecialties().get(0).toString() + "\n");
        for (Pair<Student, Integer> el : scolarshipList) {
            LOGGER.info(el.getLeft().toString() + " " + el.getRight() + "\n");
        }
    }
}
