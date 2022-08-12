package com.solvd.laba.university.interfaces;

import com.solvd.laba.university.Student;

import java.util.Date;
import java.util.List;

public interface MakingRating {
    public String makeRating(List<Student> studentList, Date date);
}
