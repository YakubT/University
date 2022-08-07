package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;

public abstract class Human {
    private String surname;
    private String name;
    private String middleName;
    private Gender gender;
    private String id;
    public Human(){

    }
    public Human(String surname,String name, Gender gender, String id){
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.id = id;
    }
    public Human(String surname,String name,String middleName,Gender gender, String id){
       this(surname,name,gender,id);
       this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "IdCard:"+id.toString()+" "+surname+" "+name+" "+middleName+" "+gender.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        return (this.id == ((Human) obj).id);
    }
}
