package com.solvd.university.enums;

public enum EducationalDegree {
    BACHELOR("first category"),
    MASTER("second category");
    private final String value;
    EducationalDegree(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
