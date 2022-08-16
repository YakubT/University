package com.solvd.university.interfaces;

import com.solvd.university.Student;

import java.util.Date;
import java.util.List;

public interface IMakingRating {
    public String makeRating(List<Student> studentList, Date date);
}
