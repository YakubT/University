package com.solvd.laba.university;

import com.solvd.laba.university.enums.TypeOfStudy;
import com.solvd.laba.university.exceptions.IncorrectEduProgramException;
import com.solvd.laba.university.exceptions.IncorrectStartYearOfStudyException;

import java.time.LocalDate;

public class StudentCard {
    private String group;
    private String studentCardId;
    private String img;
    private String universityName;
    private Faculty faculty;
    private TypeOfStudy typeOfStudy;
    private EducationalProgram EduProgram;
    private Department department;

    private int startYearOfStudy;
    public StudentCard(String studentCardId,String img,String universityName,Faculty faculty,TypeOfStudy typeOfStudy,EducationalProgram EduProgram,int startYearOfStudy){
        this.studentCardId = studentCardId;
        this.img = img;
        this.universityName = universityName;
        this.faculty = faculty;
        this.typeOfStudy = typeOfStudy;
        this.EduProgram = EduProgram;
        this.startYearOfStudy = startYearOfStudy;
        getCourseOfStudy();
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

    private boolean isFacultyHasEduProgram(EducationalProgram educationalProgram){
        for (EducationalProgram e:this.faculty.getListOfEducationalProgram()){
            if (e==educationalProgram) {
                return true;
            }
        }
        return false;
    }
    public EducationalProgram getEduProgram() {
        if (!isFacultyHasEduProgram(EduProgram))
            throw new IncorrectEduProgramException();
        return EduProgram;
    }

    public int getStartYearOfStudy() {
        return startYearOfStudy;
    }

    public String getGroup() {
        return group;
    }

    public Department getDepartment() {
        return department;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public void setEduProgram(EducationalProgram EduProgram) {
        if (this.faculty==null)
            throw new IncorrectEduProgramException("Faculty doesn't assigned: at first assign faculty");
        this.EduProgram = EduProgram;
        if (!isFacultyHasEduProgram(EduProgram))
            throw new IncorrectEduProgramException();
    }

    public void setStartYearOfStudy(int startYearOfStudy) {
        this.startYearOfStudy = startYearOfStudy;
        getCourseOfStudy();
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public int getCourseOfStudy(){
        int yearNow = LocalDate.now().getYear();
        int monthNow = LocalDate.now().getMonthValue();
        int course = yearNow-getStartYearOfStudy()+1;
        if (monthNow<9)
            course--;
        if (course<=0)
            throw new IncorrectStartYearOfStudyException("The year of study is higher than current");
        return course;
    }
}
