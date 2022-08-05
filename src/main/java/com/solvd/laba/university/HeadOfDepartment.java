package com.solvd.laba.university;

import com.solvd.laba.university.Enums.Gender;

public class HeadOfDepartment extends WorkerOfFaculty{
    public HeadOfDepartment(){

    }
    public HeadOfDepartment(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public HeadOfDepartment(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }
}
