package com.solvd.laba.university.exceptions;

public class IncorrectDepartmentException extends IncorrectStudentDataException{
    public IncorrectDepartmentException(String message){
        super(message);
    }
    public IncorrectDepartmentException(){
        super("Faculty doesn't have this department");
    }
}
