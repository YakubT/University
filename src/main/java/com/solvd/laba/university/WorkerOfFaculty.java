package com.solvd.laba.university;

public class WorkerOfFaculty extends Staff{
    String nameOfFaculty;
    String nameOfDepartment;

    public WorkerOfFaculty(){

    }
    public WorkerOfFaculty(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public WorkerOfFaculty(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }
}
