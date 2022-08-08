package com.solvd.laba;

import com.solvd.laba.university.*;
import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Main {
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
        System.out.println(rector.makeReport(listOfStudent));
        System.out.println(dean.makeReport(listOfStudent));
        HeadOfDepartment hD = new HeadOfDepartment();
        hD.setDepartment(faculties[0].getListOfDepartments().get(0));
        hD.setNameOfUniversity("КПІ");
        hD.setFaculty(faculties[0]);
        System.out.println(hD.makeReport(listOfStudent));
    }
}
