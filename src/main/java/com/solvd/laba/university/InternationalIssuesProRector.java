package com.solvd.laba.university;

public class InternationalIssuesProRector extends ProRector{
    public InternationalIssuesProRector(){

    }
    public InternationalIssuesProRector(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public InternationalIssuesProRector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
