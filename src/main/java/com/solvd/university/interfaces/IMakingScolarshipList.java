package com.solvd.university.interfaces;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.solvd.university.Faculty;
import com.solvd.university.Student;

@FunctionalInterface
public interface IMakingScolarshipList {
    public List<Pair<Student,Integer>> createScolarshipList(List<Student> studentList, Faculty faculty,
                                                           int course, int specialty);
}
