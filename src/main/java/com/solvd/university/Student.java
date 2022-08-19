package com.solvd.university;

import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.Gender;

import java.util.Date;
import java.util.List;

public class Student extends MemberOfUniversity {

    private StudentCard studentCard;
    private List<GradeBookField> gradeBook;
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
    public void setGradeBook(List<GradeBookField> gradeBook) {
        this.gradeBook = gradeBook;
    }

    public void setEducationalDegree(EducationalDegree educationalDegree) {
        this.educationalDegree = educationalDegree;
    }

    @Override
    public String toString() {
        return getSurname()+" "+getName()+" "+getStudentCard().getGroup();
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
        if (cnt==0)
            return 0;
        return sum/cnt;
    }
    public int getCourseOfStudy(){
      return studentCard.getCourseOfStudy();
    }
    public int getSpecialty(){
        return studentCard.getEduProgram().getNumberOfSpecialty();
    }
}
