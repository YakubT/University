package com.solvd.laba.university;

import com.solvd.laba.university.enums.TypeOfStudy;
import com.solvd.laba.university.exceptions.uncheked.IncorrectEduProgramException;

public class StudentCard {
    private String group;
    private String studentCardId;
    private String img;
    private String universityName;
    private Faculty faculty;
    private TypeOfStudy typeOfStudy;
    private int idOfEduProgram;
    private int startYearOfStudy;
    public StudentCard(String studentCardId,String img,String universityName,Faculty faculty,TypeOfStudy typeOfStudy,int idOfEduProgram,int startYearOfStudy){
        this.studentCardId = studentCardId;
        this.img = img;
        this.universityName = universityName;
        this.faculty = faculty;
        this.typeOfStudy = typeOfStudy;
        this.idOfEduProgram = idOfEduProgram;
        this.startYearOfStudy = startYearOfStudy;
    }
    public StudentCard(){

    }

    public String getStudentCardId() {
        return studentCardId;
    }

    public String getImg() {
        return img;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public TypeOfStudy getTypeOfStudy() {
        return typeOfStudy;
    }

    public int getIdOfEduProgram() {
        return idOfEduProgram;
    }

    public int getStartYearOfStudy() {
        return startYearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setTypeOfStudy(TypeOfStudy typeOfStudy) {
        this.typeOfStudy = typeOfStudy;
    }
    public boolean isFacultyHasEduProgram(int idOfEduProgram){
        for (EducationalProgram educationalProgram:this.faculty.getListOfEducationalProgram()){
            if (educationalProgram.getIdOfEduProgram()==idOfEduProgram) {
                return true;
            }
        }
        return false;
    }
    public void setIdOfEduProgram(int idOfEduProgram) {
        if (this.faculty==null)
            throw new IncorrectEduProgramException("Faculty doesn't assigned: at first assign faculty");

        if (!isFacultyHasEduProgram(idOfEduProgram))
            throw new IncorrectEduProgramException(this.faculty.getNameOfFaculty()+" doesn't have educationalProgram with this ID");
        this.idOfEduProgram = idOfEduProgram;
    }

    public void setStartYearOfStudy(int startYearOfStudy) {
        this.startYearOfStudy = startYearOfStudy;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
