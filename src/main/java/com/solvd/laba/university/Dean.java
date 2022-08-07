package com.solvd.laba.university;

import com.solvd.laba.university.enums.Gender;
import com.solvd.laba.university.exceptions.Uncheked.IncorrectEduProgramException;
import com.solvd.laba.university.exceptions.Uncheked.IncorrectStudentDataException;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    //input - all students of the university or all students of the faculty
    public String makeReport(List<Student> studentList) throws IncorrectStudentDataException {
       ArrayList<EducationalProgram> list = this.getFaculty().getListOfEducationalProgram();
        int[] cntOfEduProgramStudents = new int[list.size()];
        for (Student student:studentList) {
            if (student==null)
                throw new IncorrectStudentDataException("Instance of Student is null");
            if (student.getStudentCard().getFaculty().equals(this.getFaculty())) {
                int idOfEduProgram = student.getStudentCard().getIdOfEduProgram();
                if (student.getStudentCard().isFacultyHasEduProgram(idOfEduProgram)){
                    for (int i=0;i< list.size();i++)
                        if (list.get(i).getIdOfEduProgram()==idOfEduProgram) {
                            cntOfEduProgramStudents[i]++;
                            break;
                        }
                }
                else throw new IncorrectEduProgramException();

            }

        }
        int cnt = 0;
        for (int i=0;i< list.size();i++)
            cnt+=cntOfEduProgramStudents[i];
        String s1 = "There are "+cnt+" students of "+this.getFaculty();
        for (int i=0;i<list.size();i++)
            s1+="\n"+"There are "+cntOfEduProgramStudents[i]+" students of "+list.get(i).getDescription();
        return s1;
    }
}
