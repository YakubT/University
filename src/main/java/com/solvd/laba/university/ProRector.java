package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;

public abstract class ProRector extends Administration{
    public ProRector(){

    }
    public ProRector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public ProRector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
