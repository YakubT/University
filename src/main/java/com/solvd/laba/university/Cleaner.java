package com.solvd.laba.university;

public class Cleaner extends OtherStaff {
    int numberOfCleanZone;
    public Cleaner(){

    }
    public Cleaner(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public Cleaner(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public int getNumberOfCleanZone() {
        return numberOfCleanZone;
    }
    public void setNumberOfCleanZone(int numberOfCleanZone){
        this.numberOfCleanZone = numberOfCleanZone;
    }
}
