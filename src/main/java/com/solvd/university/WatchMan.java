package com.solvd.university;

import com.solvd.university.enums.Gender;

public class WatchMan extends Staff{
    private int numberOfHostel;
    public WatchMan(){

    }
    public WatchMan(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public WatchMan(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public int getNumberOfHostel() {
        return numberOfHostel;
    }

    public void setNumberOfHostel(int numberOfHostel) {
        this.numberOfHostel = numberOfHostel;
    }
}
