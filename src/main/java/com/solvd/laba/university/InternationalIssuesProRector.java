package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.interfaces.MakingReport;

import java.util.List;

public class InternationalIssuesProRector extends ProRector implements MakingReport {
    public InternationalIssuesProRector(){

    }
    public InternationalIssuesProRector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public InternationalIssuesProRector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    @Override
    public String makeReport(List<Student> studentList) {
        String s ="List of students that took part in exchange programs this semester\n";
        for (Student student:studentList){
            s+=student.toString()+"\n";
        }
        return s;
    }
}
