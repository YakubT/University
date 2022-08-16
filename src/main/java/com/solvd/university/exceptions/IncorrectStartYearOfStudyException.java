package com.solvd.university.exceptions;

public class IncorrectStartYearOfStudyException extends IncorrectStudentDataException{
    public IncorrectStartYearOfStudyException(String message){
        super(message);
    }
    public IncorrectStartYearOfStudyException(){
        super("Incorrect startYear of study");
    }
}
