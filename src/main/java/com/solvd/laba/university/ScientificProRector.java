package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.interfaces.MakingReport;

import java.util.List;

public class ScientificProRector extends ProRector implements MakingReport {
    public ScientificProRector(){

    }
    public ScientificProRector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public ScientificProRector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    @Override
    public String makeReport(List<Student> studentList) {
        return null;
    }
}
