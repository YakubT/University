package com.solvd.laba.university.enums;

public enum Gender {
    MALE("man"),
    FEMALE("woman");
    private final String value;
    Gender(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
