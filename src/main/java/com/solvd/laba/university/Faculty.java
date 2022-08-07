package com.solvd.laba.university;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String nameOfFaculty;
    private int numberOfHomeBuilding;
    private String address;
    private ArrayList<EducationalProgram> listOfEducationalProgram;
    public Faculty(){

    }
    public Faculty(String nameOfFaculty,int numberOfHomeBuilding,String address,ArrayList<EducationalProgram> listOfEducationalProgram){
        this.nameOfFaculty = nameOfFaculty;
        this.numberOfHomeBuilding = numberOfHomeBuilding;
        this.address = address;
        this.listOfEducationalProgram = listOfEducationalProgram;
    }
    public Faculty (String nameOfFaculty){
        this.nameOfFaculty = nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public void setNumberOfHomeBuilding(int numberOfHomeBuilding) {
        this.numberOfHomeBuilding = numberOfHomeBuilding;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setListOfEducationalProgram(ArrayList<EducationalProgram> listOfEducationalProgram) {
        this.listOfEducationalProgram = listOfEducationalProgram;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public int getNumberOfHomeBuilding() {
        return numberOfHomeBuilding;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<EducationalProgram> getListOfEducationalProgram() {
        return listOfEducationalProgram;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Faculty))
            return false;
        return ((Faculty) obj).nameOfFaculty.equals(this.nameOfFaculty);
    }
}
