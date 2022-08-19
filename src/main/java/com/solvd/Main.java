package com.solvd;

import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.Gender;

import java.time.LocalDate;
import java.util.*;


import com.solvd.university.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.util.FileUtils;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        /*
        Faculty[] faculties = {new Faculty("ФПМ")};
        List<Student> listOfStudent = new ArrayList<Student>();
        listOfStudent.add(new Student("Іванов","Іван", Gender.MALE,"abcde","КПІ",new StudentCard(), EducationalDegree.BACHELOR));
        listOfStudent.add(new Student("Петров","Петро",Gender.MALE,"fabcde","КПІ",new StudentCard(),EducationalDegree.BACHELOR));
        listOfStudent.get(0).getStudentCard().setStudentCardId("1");
        listOfStudent.get(1).getStudentCard().setStudentCardId("2");
        listOfStudent.get(0).getStudentCard().setFaculty(faculties[0]);
        listOfStudent.get(1).getStudentCard().setFaculty(faculties[0]);
        faculties[0].setListOfDepartments(new ArrayList<Department>());
        faculties[0].getListOfDepartments().add(new Department("ПЗКС"));
        faculties[0].getListOfDepartments().get(0).setListOfEduPrograms(new ArrayList<EducationalProgram>());
        faculties[0].getListOfDepartments().get(0).getListOfEduPrograms().add(new EducationalProgram(121,1121,"Інженерія програмного забезпечення мультимедійних та інформаційно-пошукових систем"));
        listOfStudent.get(0).getStudentCard().setDepartment(faculties[0].getListOfDepartments().get(0));
        listOfStudent.get(0).getStudentCard().setEduProgram(faculties[0].getListOfDepartments().get(0).getListOfEduPrograms().get(0));
        listOfStudent.get(0).getStudentCard().setStartYearOfStudy(2021);
        listOfStudent.get(1).getStudentCard().setDepartment(faculties[0].getListOfDepartments().get(0));
        listOfStudent.get(1).getStudentCard().setEduProgram(faculties[0].getListOfDepartments().get(0).getListOfEduPrograms().get(0));
        listOfStudent.get(1).getStudentCard().setStartYearOfStudy(2021);
        listOfStudent.get(0).getStudentCard().setGroup("КП-12");
        listOfStudent.get(1).getStudentCard().setGroup("КП-11");;
        Rector rector = new Rector();
        rector.setNameOfUniversity("КПІ");
        Dean dean = new Dean();
        dean.setNameOfUniversity("КПІ");
        dean.setFaculty(faculties[0]);
        LOGGER.info(rector.makeReport(listOfStudent));
        LOGGER.info("\n");
        LOGGER.info(dean.makeReport(listOfStudent));
        LOGGER.info("\n");
        HeadOfDepartment hD = new HeadOfDepartment();
        hD.setDepartment(faculties[0].getListOfDepartments().get(0));
        hD.setNameOfUniversity("КПІ");
        hD.setFaculty(faculties[0]);
        LOGGER.info(hD.makeReport(listOfStudent));
        LOGGER.info("\n");
        LOGGER.info(listOfStudent.get(0).toString());
        ScientificProRector sPr = new ScientificProRector();
        sPr.setNameOfUniversity("КПІ");
        InternationalIssuesProRector iPr = new InternationalIssuesProRector();
        iPr.setNameOfUniversity("КПІ");
        LOGGER.info(sPr.makeReport(listOfStudent));
        LOGGER.info("\n");
        LOGGER.info(iPr.makeReport(listOfStudent));

        ArrayList<GradeBookField> gradeBook = new ArrayList<GradeBookField>();
        Date day;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2022);
        calendar.set(Calendar.MONTH,6);
        calendar.set(Calendar.DATE,30);
        day = calendar.getTime();
        gradeBook.add(new GradeBookField(dean,"Basics of programming",75,day));
        listOfStudent.get(0).setGradeBook(gradeBook);
        ArrayList<GradeBookField> gradeBook2 = new ArrayList<GradeBookField>();
        gradeBook2.add(new GradeBookField(dean,"Basics of programming",100,day));
        listOfStudent.get(1).setGradeBook(gradeBook2);
        calendar.set(Calendar.DATE,5);
        Date day2 = calendar.getTime();
        LOGGER.info(dean.makeRating(listOfStudent,day2));
         */
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
        Faculty facultyArr[] = new Faculty[RandomUtils.nextInt(10, 50)];
        int startIdOfEduProgram = 0;
        Dean deanArr[] = new Dean[facultyArr.length];
        List<HeadOfDepartment> headOfDepartmentList = new ArrayList<HeadOfDepartment>();
        for (int i = 0; i < facultyArr.length; i++) {
            facultyArr[i] = new Faculty(RandomGeneration.getNameOfSubDivision());
            facultyArr[i].setNameOfUniversity(universityList.get(RandomUtils.nextInt(0, universityList.size())));
            ArrayList<Department> departmentList = new ArrayList<Department>();
            int sizeDep = RandomUtils.nextInt(2, 5);
            for (int j = 0; j < sizeDep; j++) {
                ArrayList<EducationalProgram> educationalPrograms = new ArrayList<EducationalProgram>();
                int sizeEd = RandomUtils.nextInt(1,3);
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
            studentList.add(student);
        }
        for (int i = 0; i < 3; i++) {
            LOGGER.info(rectorList.get(i).makeReport(studentList));
        }
        LOGGER.info("dean of "+deanArr[0].getFaculty()+" "+deanArr[0].getNameOfUniversity());
        LOGGER.info(deanArr[0].makeReport(studentList));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DATE,1);
        LOGGER.info(deanArr[0].makeRating(studentList,calendar.getTime()));
    }
}
