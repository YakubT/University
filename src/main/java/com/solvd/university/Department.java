package com.solvd.university;

import java.util.ArrayList;

public class Department {

    private String nameOfDepartment;

    private ArrayList<EducationalProgram> listOfEduPrograms;

    public Department(){

    }

    public Department(String nameOfDepartment,ArrayList<EducationalProgram> listOfEduPrograms){
        this.nameOfDepartment = nameOfDepartment;
        this.listOfEduPrograms = listOfEduPrograms;
    }

    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public ArrayList<EducationalProgram> getListOfEduPrograms() {
        return listOfEduPrograms;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setListOfEduPrograms(ArrayList<EducationalProgram> listOfEduPrograms) {
        this.listOfEduPrograms = listOfEduPrograms;
    }

    @Override
    public String toString() {
        return nameOfDepartment;
    }
}
