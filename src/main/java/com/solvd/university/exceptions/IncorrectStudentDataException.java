package com.solvd.university.exceptions;

public class IncorrectStudentDataException extends RuntimeException{
    public IncorrectStudentDataException(String message){
        super(message);
    }
}
