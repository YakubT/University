package com.solvd.university.enums;

public enum SocialSupport {
    NONE("none"),

    QUOTA1("quota1"),

    QUOTA2("quota2");

    private String value;

    SocialSupport (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
