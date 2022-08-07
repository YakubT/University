package com.solvd.laba;

import com.solvd.laba.university.Student;
import com.solvd.laba.university.StudentCard;
import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;

public class Main {
    public static void main(String[] args){
        Student tolik = new Student("Yakubyshyn","Anatolii","Serhiyovich",Gender.MALE,"abcd00991","NTUU KPI",new StudentCard(), EducationalDegree.BACHELOR);
        System.out.println(tolik.toString());
    }
}
