package com.solvd.laba.university;

import java.util.List;

public abstract class Student extends MemberOfUniversity {

    StudentCard studentCard;
    private List<GradeBookField> gradeBook;
    private int numberOfCourse;
    public Student(){

    }
    public Student(String surname,String name,Gender gender,String id,String nameOfUniversity, StudentCard studentCard){
        super(surname,name,gender,id,nameOfUniversity);
        this.studentCard = studentCard;
    }
    public Student(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity, StudentCard studentCard){
        this(surname,name,gender,id,nameOfUniversity,studentCard);
        this.setMiddleName(middleName);
    }
    public StudentCard getStudentCard() {
        return studentCard;
    }


    public List<GradeBookField> getGradeBook() {
        return gradeBook;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }
    public int getNumberOfCourse(){
        return numberOfCourse;
    }
    public void setGradeBook(List<GradeBookField> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public void setNumberOfCourse(int numberOfCourse) {
        this.numberOfCourse = numberOfCourse;
    }
}
