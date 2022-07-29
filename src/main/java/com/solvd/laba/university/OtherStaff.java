package com.solvd.laba.university;

public abstract class OtherStaff extends Staff {
    public OtherStaff(){

    }
    public OtherStaff(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public OtherStaff(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
