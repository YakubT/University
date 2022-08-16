package com.solvd.university;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Faculty {
    private String nameOfFaculty;
    private int numberOfHomeBuilding;
    private String address;
    private ArrayList<Department> listOfDepartments;
    public Faculty(){

    }
    public Faculty(String nameOfFaculty,int numberOfHomeBuilding,String address,ArrayList<Department> listOfDepartments){
        this.nameOfFaculty = nameOfFaculty;
        this.numberOfHomeBuilding = numberOfHomeBuilding;
        this.address = address;
        this.listOfDepartments = listOfDepartments;
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

    public void setListOfDepartments(ArrayList<Department> listOfDepartments) {
        this.listOfDepartments = listOfDepartments;
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

    public ArrayList<Department> getListOfDepartments() {
        return listOfDepartments;
    }

    public ArrayList<EducationalProgram> getListOfEducationalProgram(){
        ArrayList<EducationalProgram> educationalPrograms = new ArrayList<EducationalProgram>();
        for (Department dep:listOfDepartments){
            ArrayList<EducationalProgram> eduProgramsOfDepartment = dep.getListOfEduPrograms();
            educationalPrograms.addAll(eduProgramsOfDepartment);
        }
        return  educationalPrograms;
    }
    public List<Integer> getListOfSpecialties(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<EducationalProgram> educationalPrograms = getListOfEducationalProgram();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (EducationalProgram e:educationalPrograms){
            if (!hashSet.contains(e.getNumberOfSpecialty())) {
                res.add(e.getNumberOfSpecialty());
                hashSet.add(e.getNumberOfSpecialty());
            }
        }
        return res;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Faculty))
            return false;
        return ((Faculty) obj).nameOfFaculty.equals(this.nameOfFaculty);
    }

    @Override
    public String toString() {
        return nameOfFaculty;
    }

    @Override
    public int hashCode() {
        return nameOfFaculty.hashCode();
    }
}
