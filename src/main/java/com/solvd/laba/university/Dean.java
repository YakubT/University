package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.IncorrectEduProgramException;
import com.solvd.laba.university.exceptions.IncorrectStudentDataException;
import com.solvd.laba.university.interfaces.MakingReport;

import java.util.ArrayList;
import java.util.List;

public class Dean extends WorkerOfFaculty implements MakingReport {
    public Dean() {

    }

    public Dean(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Dean(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }

    //input - all students of the university or all students of the faculty
    @Override
    public String makeReport(List<Student> studentList)  {
       ArrayList<EducationalProgram> list = this.getFaculty().getListOfEducationalProgram();
        int[] cntOfEduProgramStudents = new int[list.size()];
        for (Student student:studentList) {
            if (student==null)
                throw new IncorrectStudentDataException("Instance of Student is null");
            EducationalProgram educationalProgram = student.studentCard.getEduProgram();
            if (student.studentCard.getUniversityName().equals(getNameOfUniversity()) && student.getStudentCard().getFaculty().equals(this.getFaculty())) {
                    for (int i=0;i< list.size();i++)
                        if (list.get(i).equals(educationalProgram)) {
                            cntOfEduProgramStudents[i]++;
                            break;
                        }
            }

        }
        int cnt = 0;
        for (int i=0;i< list.size();i++)
            cnt+=cntOfEduProgramStudents[i];
        String s1 = "There are "+cnt+" students of "+this.getFaculty().toString();
        for (int i=0;i<list.size();i++)
            s1+="\n"+"There are "+cntOfEduProgramStudents[i]+" students of "+list.get(i).getDescription();
        return s1;
    }
}
