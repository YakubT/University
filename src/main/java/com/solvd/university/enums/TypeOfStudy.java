package com.solvd.university.enums;

public enum TypeOfStudy {

    EXTRAMURAL("extramural"),

    FULL_TIME("full-time");

    private final String value;

    TypeOfStudy(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
