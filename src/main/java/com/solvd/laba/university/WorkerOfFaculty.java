package com.solvd.laba.university;

public class WorkerOfFaculty extends Staff{
    private Faculty faculty;
    private String nameOfDepartment;
    private String scientificDegree;
    public WorkerOfFaculty(){

    }
    public WorkerOfFaculty(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public WorkerOfFaculty(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public String getScientificDegree() {
        return scientificDegree;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setScientificDegree(String scientificDegree) {
        this.scientificDegree = scientificDegree;
    }
}
