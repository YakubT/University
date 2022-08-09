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
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        for (Student student:studentList) {
            if (student.getNameOfUniversity()==null)
                throw new IncorrectStudentDataException("The university isn't indicated"); 
            if (student.getNameOfUniversity().equals(getNameOfUniversity())) {
                Integer cnt = hashMap.get(student.getStudentCard().getFaculty().toString());
                int iCnt;
                if (cnt == null)
                    iCnt = 0;
                else
                    iCnt = cnt.intValue();
                iCnt++;
                hashMap.put(student.getStudentCard().getFaculty().toString(), iCnt);
            }
        }
        String s = "";
        int cnt=0;
        Set<Map.Entry<String,Integer>> set = hashMap.entrySet();
        for (Map.Entry<String,Integer> e:set){
            s+="There are "+e.getValue().toString()+" at "+e.getKey().toString()+"\n";
            cnt  += e.getValue().intValue();
        }
        s="There are "+String.valueOf(cnt)+" of students at "+getNameOfUniversity()+"\n"+s;
        return  s;
    }
}
