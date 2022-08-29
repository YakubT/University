package com.solvd.university;

import com.solvd.university.enums.Gender;

public class Guardian extends Staff{

    private int numberOfZone;

    public Guardian(){

    }

    public Guardian(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }

    public Guardian(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public int getNumberOfZone() {
        return numberOfZone;
    }

    public void setNumberOfZone(int numberOfZone) {
        this.numberOfZone = numberOfZone;
    }
}
