package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;

public abstract class MemberOfUniversity extends Human {
    private String nameOfUniversity;
    public MemberOfUniversity(){

    }
    public MemberOfUniversity(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id);
        this.nameOfUniversity = nameOfUniversity;
    }
    public MemberOfUniversity(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id);
        this.nameOfUniversity = nameOfUniversity;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }
}
