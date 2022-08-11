package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.IncorrectStudentDataException;
import com.solvd.laba.university.interfaces.MakingReport;

import java.util.*;

public class Rector extends Administration implements MakingReport {
    public Rector() {

    }

    public Rector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Rector(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }

    @Override
    public String makeReport(List<Student> studentList) {
        if (studentList.stream().anyMatch(Objects::isNull))
            throw new IncorrectStudentDataException("Instance of Student is null");
        if (studentList.stream().anyMatch(student -> student.getNameOfUniversity()==null))
            throw new IncorrectStudentDataException("The university isn't indicated");
        int cnt = (int) studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())).count();
        String s = "There are "+cnt+" students of "+getNameOfUniversity();
        HashMap<Faculty,Integer> cntOfStudentsOfFaculty = new HashMap<Faculty,Integer>();
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
        ).forEach(student -> {
            int c = 0;
            if (cntOfStudentsOfFaculty.get(student.getStudentCard().getFaculty())!=null)
                c = cntOfStudentsOfFaculty.get(student.getStudentCard().getEduProgram())+1;
            else
                c=1;
            cntOfStudentsOfFaculty.put(student.getStudentCard().getFaculty(),c);
        });
        for (Map.Entry<Faculty,Integer> entry:cntOfStudentsOfFaculty.entrySet()) {
            s+="\n"+"There are "+entry.getValue()+" students of "+entry.getKey().toString();
        }
        return  s;
    }
}
