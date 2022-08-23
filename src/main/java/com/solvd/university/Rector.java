package com.solvd.university;

import com.solvd.university.enums.Gender;
import com.solvd.university.exceptions.IncorrectStudentDataException;
import com.solvd.university.interfaces.IMakingReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Rector extends Administration implements IMakingReport {
    private static final Logger LOGGER = LogManager.getLogger(Rector.class.getName());
    public Rector() {

    }

    public Rector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, middleName, gender, id, nameOfUniversity);
    }

    public Rector(String surname, String name, Gender gender, String id, String nameOfUniversity) {
        super(surname, name, gender, id, nameOfUniversity);
    }

    @Override
    public void makeReport(List<Student> studentList) {
        if (studentList.stream().anyMatch(Objects::isNull)) {
            throw new IncorrectStudentDataException("Instance of Student is null");
        }
        if (studentList.stream().anyMatch(student -> student.getNameOfUniversity() == null)) {
            throw new IncorrectStudentDataException("The university isn't indicated");
        }
        int cnt = (int) studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())).count();
        LOGGER.info("There are " + cnt + " students of " + getNameOfUniversity()+"\n");
        HashMap<Faculty, Integer> cntOfStudentsOfFaculty = new HashMap<Faculty, Integer>();
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())
        ).forEach(student -> {
            int c = 0;
            if (cntOfStudentsOfFaculty.get(student.getStudentCard().getFaculty()) != null) {
                c = cntOfStudentsOfFaculty.get(student.getStudentCard().getFaculty()) + 1;
            } else {
                c = 1;
            }
            cntOfStudentsOfFaculty.put(student.getStudentCard().getFaculty(), c);
        });
        cntOfStudentsOfFaculty.forEach((key, value) -> LOGGER.info("There are " + value + " students of " + key.toString()+"\n"));
    }
}
