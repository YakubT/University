package com.solvd.laba.university;

import java.util.List;

public class Faculty {
    private String nameOfFaculty;
    private int numberOfHomeBuilding;
    private String address;
    private List<EducationalProgram> listOfEducationalProgram;
    public Faculty(){

    }
    public Faculty(String nameOfFaculty,int numberOfHomeBuilding,String address,List<EducationalProgram> listOfEducationalProgram){
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

    public void setListOfEducationalProgram(List<EducationalProgram> listOfEducationalProgram) {
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

    public List<EducationalProgram> getListOfEducationalProgram() {
        return listOfEducationalProgram;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Faculty))
            return false;
        return ((Faculty) obj).nameOfFaculty.equals(this.nameOfFaculty);
    }
}
