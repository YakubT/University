package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;

import java.util.List;

public class Dean extends WorkerOfFaculty {
    public Dean() {

    }

    public Dean(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Dean(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }

    public String makeReport(List<Student> studentList) {
        int cntOfFacultyStudents = 0;
        if (studentList!=null)
        for (Student student : studentList) {
            if (student.getStudentCard().getFaculty().equals(this.getFaculty()))
                cntOfFacultyStudents++;
        }
        return "There are "+cntOfFacultyStudents+" student at "+this.getFaculty().getNameOfFaculty();
    }
}
