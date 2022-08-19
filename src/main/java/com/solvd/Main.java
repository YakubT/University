package com.solvd;

import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.Gender;

import java.util.*;


import com.solvd.university.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.util.FileUtils;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args){
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
        for (int i=0;i<3;i++) {
            universityList.add(RandomGeneration.getRandomString().toUpperCase());
            rectorList.add(new Rector());
            rectorList.get(i).setSurname(RandomGeneration.getRandomSurnameOrName());
            rectorList.get(i).setName(RandomGeneration.getRandomSurnameOrName());
            rectorList.get(i).setNameOfUniversity(universityList.get(i));
        }
        Faculty facultyArr[] = new Faculty[RandomUtils.nextInt(10,50)];
        int startIdOfEduProgram = 0;
        Dean deanArr[] = new Dean[facultyArr.length];
        for (int i=0;i<facultyArr.length;i++) {
            facultyArr[i] = new Faculty(RandomGeneration.getNameOfSubDivision());
            ArrayList<Department> departmentList = new ArrayList<Department>();
            int sizeDep = RandomUtils.nextInt(2,6);
            for (int j=0;j<sizeDep;j++) {
                    ArrayList<EducationalProgram> educationalPrograms = new ArrayList<EducationalProgram>();
                    int sizeEd = RandomUtils.nextInt(2,6);
                    for (int o =0;o< sizeEd;o++)
                        educationalPrograms.add(new EducationalProgram(RandomUtils.nextInt(100,200),startIdOfEduProgram++,RandomGeneration.getRandomString()));
                departmentList.add(new Department(RandomGeneration.getNameOfSubDivision(),educationalPrograms));
            }
            facultyArr[i].setListOfDepartments(departmentList);
            facultyArr[i].setNameOfUniversity(universityList.get(RandomUtils.nextInt(0,universityList.size())));
            deanArr[i] = new Dean();
            deanArr[i].setFaculty(facultyArr[i]);
            deanArr[i].setNameOfUniversity(facultyArr[i].getNameOfUniversity());
            deanArr[i].setName(RandomGeneration.getRandomSurnameOrName());
            deanArr[i].setSurname(RandomGeneration.getRandomSurnameOrName());
        }


    }
}
