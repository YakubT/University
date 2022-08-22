package com.solvd.university;

import com.solvd.university.enums.Gender;
import com.solvd.university.interfaces.IMakingReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ScientificProRector extends ProRector implements IMakingReport {
    private static Logger LOGGER = LogManager.getLogger(ScientificProRector.class.getName());
    public ScientificProRector(){

    }
    public ScientificProRector(String surname, String name, String middleName, Gender gender, String id, String nameOfUniversity){
        super(surname,name,middleName,gender,id,nameOfUniversity);
    }
    public ScientificProRector(String surname,String name,Gender gender,String id,String nameOfUniversity){
        super(surname,name,gender,id,nameOfUniversity);
    }

    @Override
    public void makeReport(List<Student> studentList) {
        LOGGER.info("List of students that created scientific works\n");
        studentList.stream().filter(student -> student.getNameOfUniversity().equals(getNameOfUniversity())).forEach(
               student-> LOGGER.info(student.toString()+"\n"));
    }
}
