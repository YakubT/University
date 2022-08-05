package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;

public class Rector extends Administration{
    public Rector(){

    }
    public Rector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public Rector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
