package com.solvd.university.interfaces;

import java.util.Date;
import java.util.List;

import com.solvd.university.Student;

public interface IMakingRating {
    public void makeRating(List<Student> studentList, Date date,ICalculatingRatingScore calc);
}
