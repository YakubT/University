package com.solvd.university.interfaces;


import com.solvd.university.Faculty;
import com.solvd.university.Student;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface IMakingScolarshipList {
    public List<Pair<Student,Integer>> createScolarshipList(List<Student> studentList, Faculty faculty,
                                                           int course, int specialty);
}
