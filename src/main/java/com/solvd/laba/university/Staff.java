package com.solvd.laba.university;

public abstract class Staff extends MemberOfUniversity{
    private int salary;
    private int yearOfStartWorking;
    public Staff(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public Staff(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public int getSalary() {
        return salary;
    }

    public int getYearOfStartWorking() {
        return yearOfStartWorking;
    }

}
