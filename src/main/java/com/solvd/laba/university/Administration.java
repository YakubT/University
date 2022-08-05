package com.solvd.laba.university;

import com.solvd.laba.university.Enums.Gender;

public abstract class Administration extends Staff{
    public Administration(){

    }
    public Administration(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public Administration(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
