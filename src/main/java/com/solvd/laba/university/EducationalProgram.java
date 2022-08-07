package com.solvd.laba.university;

public class EducationalProgram {
    private int idOfEduProgram;
    private int numberOfSpecialty;
    private String description;
    public EducationalProgram(int numberOfSpecialty,int idOfEduProgram){
        this.idOfEduProgram = idOfEduProgram;
        this.numberOfSpecialty = numberOfSpecialty;
    }

    public void setIdOfEduProgram(int idOfEduProgram) {
        this.idOfEduProgram = idOfEduProgram;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfSpecialty(int numberOfSpecialty) {
        this.numberOfSpecialty = numberOfSpecialty;
    }

    public int getIdOfEduProgram() {
        return idOfEduProgram;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfSpecialty() {
        return numberOfSpecialty;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EducationalProgram))
            return false;
        return  (((EducationalProgram) obj).idOfEduProgram == this.idOfEduProgram);
    }
}