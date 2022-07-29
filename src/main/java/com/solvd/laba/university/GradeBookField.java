package com.solvd.laba.university;

import java.util.Date;

public class GradeBookField {
    private WorkerOfFaculty teacher;
    private String subject;
    private int score;
    private String scoreLetter;
    private Date date;
    public GradeBookField(WorkerOfFaculty teacher,String subject,int score,String scoreLetter,Date date){
        this.teacher = teacher;
        this.subject = subject;
        this.score = score;
        this.scoreLetter = scoreLetter;
        this.date = date;
    }

    public WorkerOfFaculty getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    public String getScoreLetter() {
        return scoreLetter;
    }

    public Date getDate() {
        return date;
    }

    public void setTeacher(WorkerOfFaculty teacher) {
        this.teacher = teacher;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreLetter(String scoreLetter) {
        this.scoreLetter = scoreLetter;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
