package com.solvd.university.interfaces;

import java.util.Date;
import java.util.List;

import com.solvd.university.GradeBookField;

@FunctionalInterface
public interface ICalculatingRatingScore {
    public double calculateRatingScore(List<GradeBookField> gradeBook, int additionalPoints, Date date);
}
