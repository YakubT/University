package com.solvd.university;

import java.util.Date;
import java.util.List;

import com.solvd.university.enums.EducationalDegree;
import com.solvd.university.enums.Gender;
import com.solvd.university.enums.SocialSupport;
import com.solvd.university.interfaces.ICalculatingRatingScore;

public class Student extends MemberOfUniversity {

    private StudentCard studentCard;

    private int additionalPoints;

    private SocialSupport socialSupport = SocialSupport.NONE;

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

    public double calculateRatingScore(ICalculatingRatingScore calc,Date dt){
        return  calc.calculateRatingScore(gradeBook,additionalPoints,dt);
    }

    public int getCourseOfStudy(){
      return studentCard.getCourseOfStudy();
    }

    public int getSpecialty(){
        return studentCard.getEduProgram().getNumberOfSpecialty();
    }

    public void setSocialSupport(SocialSupport socialSupport) {
        this.socialSupport = socialSupport;
    }

    public SocialSupport getSocialSupport() {
        return socialSupport;
    }

    public int getAdditionalPoints() {
        return additionalPoints;
    }

    public void setAdditionalPoints(int additionalPoints) {
        this.additionalPoints = additionalPoints;
    }
}
