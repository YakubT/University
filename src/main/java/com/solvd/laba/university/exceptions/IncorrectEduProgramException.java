package com.solvd.laba.university.exceptions;

public class IncorrectEduProgramException extends IncorrectStudentDataException {
    public IncorrectEduProgramException(String message){
        super(message);
    }
    public IncorrectEduProgramException(){
        super("Incorrect educational program");
    }
}
