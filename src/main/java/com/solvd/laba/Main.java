package com.solvd.laba;

import com.solvd.laba.university.*;
import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args){
        Faculty[] faculties = {new Faculty("ФПМ")};
        List<Student> listOfStudent = new ArrayList<Student>();
        listOfStudent.add(new Student("Іванов","Іван",Gender.MALE,"abcde","КПІ",new StudentCard(),EducationalDegree.BACHELOR));
        listOfStudent.get(0).getStudentCard().setStudentCardId("1");
        listOfStudent.get(0).getStudentCard().setFaculty(faculties[0]);
        faculties[0].setListOfDepartments(new ArrayList<Department>());
        faculties[0].getListOfDepartments().add(new Department("ПЗКС"));
        faculties[0].getListOfDepartments().get(0).setListOfEduPrograms(new ArrayList<EducationalProgram>());
        faculties[0].getListOfDepartments().get(0).getListOfEduPrograms().add(new EducationalProgram(121,1121,"Інженерія програмного забезпечення мультимедійних та інформаційно-пошукових систем"));
        listOfStudent.get(0).getStudentCard().setDepartment(faculties[0].getListOfDepartments().get(0));
        listOfStudent.get(0).getStudentCard().setEduProgram(faculties[0].getListOfDepartments().get(0).getListOfEduPrograms().get(0));
        Rector rector = new Rector();
        rector.setNameOfUniversity("КПІ");
        Dean dean = new Dean();
        dean.setNameOfUniversity("КПІ");
        dean.setFaculty(faculties[0]);
        logger.info(rector.makeReport(listOfStudent));
        logger.info("\n");
        logger.info(dean.makeReport(listOfStudent));
        logger.info("\n");
        HeadOfDepartment hD = new HeadOfDepartment();
        hD.setDepartment(faculties[0].getListOfDepartments().get(0));
        hD.setNameOfUniversity("КПІ");
        hD.setFaculty(faculties[0]);
        logger.info(hD.makeReport(listOfStudent));
        logger.info("\n");
        listOfStudent.get(0).getStudentCard().setGroup("КП-12");
        logger.info(listOfStudent.get(0).toString());
        ScientificProRector sPr = new ScientificProRector();
        sPr.setNameOfUniversity("КПІ");
        InternationalIssuesProRector iPr = new InternationalIssuesProRector();
        iPr.setNameOfUniversity("КПІ");
        logger.info(sPr.makeReport(listOfStudent));
        logger.info("\n");
        logger.info(iPr.makeReport(listOfStudent));
    }
}
