package com.solvd.laba.university;

public abstract class Student extends MemberOfUniversity {
    private String studentCardId;

    private int setYearOfStudy;
    public Student(){

    }
    public Student(String surname,String name,Gender gender,String id,String nameOfUniversity, String studentCardId){
        super(surname,name,gender,id,nameOfUniversity);
        this.studentCardId = studentCardId;
    }
    public Student(String surname,String name,String middleName,Gender gender,String id,String nameOfUniversity, String studentCardId){
        this(surname,name,gender,id,nameOfUniversity,studentCardId);
        this.setMiddleName(middleName);
    }
    public String getStudentCardId() {
        return studentCardId;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }


}
