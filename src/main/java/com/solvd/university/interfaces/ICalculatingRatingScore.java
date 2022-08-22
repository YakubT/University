package com.solvd.university.interfaces;

import com.solvd.university.GradeBookField;

import java.util.Date;
import java.util.List;

@FunctionalInterface
public interface ICalculatingRatingScore {
    public double calculateRatingScore(List<GradeBookField> gradeBook, int additionalPoints, Date date);
}
