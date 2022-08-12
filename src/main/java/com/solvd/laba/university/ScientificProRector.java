package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.interfaces.IMakingReport;

import java.util.List;

public class ScientificProRector extends ProRector implements IMakingReport {
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
        String s ="List of students that created scientific works\n";
        for (Student student:studentList){
            s+=student.toString()+"\n";
        }
        return s;
    }
}
