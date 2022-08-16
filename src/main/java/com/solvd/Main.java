package com.solvd;

import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.Gender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.solvd.university.*;
import org.apache.logging.log4j.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args){

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
    }
}
