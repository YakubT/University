package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.IncorrectStudentDataException;
import com.solvd.laba.university.interfaces.IMakingReport;

import java.util.*;

public class HeadOfDepartment extends WorkerOfFaculty implements IMakingReport {

    public HeadOfDepartment(){

    }
    public HeadOfDepartment(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public HeadOfDepartment(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    // input allStudents of university or all Students of Faculty or all Students of Department
    @Override
    public String makeReport(List<Student> studentList) {

        if (studentList.stream().anyMatch(Objects::isNull))
            throw new IncorrectStudentDataException("Instance of Student is null");
        if (studentList.stream().anyMatch(student -> student.getNameOfUniversity()==null))
            throw new IncorrectStudentDataException("The university isn't indicated");
        int cnt = (int) studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getDepartment().equals(getDepartment())).count();
        String s = "There are "+cnt+" students of "+getDepartment().toString();
        HashMap<EducationalProgram,Integer> cntOfStudentsOfEduProgram = new HashMap<EducationalProgram,Integer>();
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
                && student.getStudentCard().getDepartment().equals(getDepartment())).forEach(student -> {
            int c = 0;
            if (cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram())!=null)
                c = cntOfStudentsOfEduProgram.get(student.getStudentCard().getEduProgram())+1;
            else
                c=1;
            cntOfStudentsOfEduProgram.put(student.getStudentCard().getEduProgram(),c);
        });
        for (Map.Entry<EducationalProgram,Integer> entry:cntOfStudentsOfEduProgram.entrySet()) {
            s+="\n"+"There are "+entry.getValue()+" students of "+entry.getKey().getDescription();
        }
        return  s;
    }
}
