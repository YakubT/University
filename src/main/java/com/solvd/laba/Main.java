package com.solvd.laba;

import com.solvd.laba.university.*;
import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Faculty[] faculties = {new Faculty("FAM"),new Faculty("IASA"),new Faculty("FICE")};
        List<Student> listOfStudent = new ArrayList<Student>();
        listOfStudent.add(new Student("Yakubyshyn","Anatolii",Gender.MALE,"abcde","KPI",new StudentCard(),EducationalDegree.BACHELOR));
        listOfStudent.get(0).getStudentCard().setStudentCardId("1");
        listOfStudent.get(0).getStudentCard().setFaculty(faculties[0]);
        //faculties[0].setListOfEducationalProgram(new ArrayList<Department>(){new Department("")});
    }
}
