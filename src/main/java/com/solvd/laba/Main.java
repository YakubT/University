package com.solvd.laba;

import com.solvd.laba.university.Dean;
import com.solvd.laba.university.Faculty;
import com.solvd.laba.university.Student;
import com.solvd.laba.university.StudentCard;
import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Student tolik = new Student("Yakubyshyn","Anatolii","Serhiyovich",Gender.MALE,"abcd00991","NTUU KPI",new StudentCard(), EducationalDegree.BACHELOR);
        tolik.getStudentCard().setStudentCardId("100bc78");
        tolik.getStudentCard().setFaculty(new Faculty("FAM"));
        System.out.println(tolik.toString());
        Dean Dychka = new Dean("Dychka","Ivan","Andriyoych",Gender.MALE,"297uuu","NTUU KPI");
        Dychka.setFaculty(new Faculty("FAM"));
        Dychka.setNameOfDepartment("ПЗКС");
        System.out.println(Dychka.toString());
        List<Student> list = new ArrayList<Student>();
        list.add(tolik);
        System.out.println(Dychka.makeReport(list));
    }
}
