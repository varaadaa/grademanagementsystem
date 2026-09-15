package com.gradeapp.service;

import com.gradeapp.model.Result;
import com.gradeapp.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that handles storing results and basic operations:
 * add result, view all, find topper.
 */
public class GradeService {
    private List<Result> results;

    public GradeService() {
        this.results = new ArrayList<>();
    }

    public void addResult(String name, String roll, int m1, int m2, int m3) {
        Student s = new Student(name, roll);
        Result r = new Result(s, m1, m2, m3);
        results.add(r);
    }

    public List<Result> getAllResults() {
        return results;
    }

    public Result getTopper() {
        if (results.isEmpty()) return null;
        Result top = results.get(0);
        for (Result r : results) {
            if (r.getTotal() > top.getTotal()) {
                top = r;
            }
        }
        return top;
    }

    public boolean hasResults() {
        return !results.isEmpty();
    }
}