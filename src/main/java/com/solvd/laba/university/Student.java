package com.solvd.laba.university;

import com.solvd.laba.university.enums.EducationalDegree;
import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.IncorrectStartYearOfStudyException;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Student extends MemberOfUniversity {

    StudentCard studentCard;
    private List<GradeBookField> gradeBook;
    private int numberOfCourse;
    private EducationalDegree educationalDegree;
    public Student(){

    }
    public Student(String surname, String name, Gender gender, String id, String nameOfUniversity, StudentCard studentCard, EducationalDegree educationalDegree){
        super(surname,name,gender,id,nameOfUniversity);
        this.studentCard = studentCard;
        this.educationalDegree  = educationalDegree;
    }
    public Student(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity, StudentCard studentCard,EducationalDegree educationalDegree){
        this(surname,name,gender,id,nameOfUniversity,studentCard,educationalDegree);
        this.setMiddleName(middleName);
    }
    public StudentCard getStudentCard() {
        return studentCard;
    }


    public List<GradeBookField> getGradeBook() {
        return gradeBook;
    }

    public EducationalDegree getEducationalDegree() {
        return educationalDegree;
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

    public void setEducationalDegree(EducationalDegree educationalDegree) {
        this.educationalDegree = educationalDegree;
    }

    @Override
    public String toString() {
        return super.toString()+" University:"+this.getNameOfUniversity()+" StudId:"+studentCard.getStudentCardId();
    }
    public double calculateRatingScore(Date date){
        double sum = 0;
        int cnt = 0;
        for (GradeBookField field:gradeBook){
            if (field.getDate().compareTo(date)>=0){
                sum+=field.getScore();
                cnt++;
            }
        }
        return sum/cnt;
    }
    public int getCourseOfStudy(){
      return studentCard.getCourseOfStudy();
    }
}
