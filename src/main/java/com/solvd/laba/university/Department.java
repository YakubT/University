package com.solvd.laba.university;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String nameOfDepartment;
    private ArrayList<EducationalProgram> listOfEduPrograms;
    public Department(){

    }
    public Department(String nameOfDepartment,ArrayList<EducationalProgram> listOfEduPrograms){
        this.nameOfDepartment = nameOfDepartment;
        this.listOfEduPrograms = listOfEduPrograms;
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
