package com.gradeapp.util;

import com.gradeapp.model.Result;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Saves the class report to a text file.
 */
public class FileLogger {

    private static final String FILE_NAME = "class_report.txt";

    public static boolean saveReport(List<Result> results) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            out.println("Class Report");
            out.println("Generated at: " + LocalDateTime.now());
            out.println("------------------------------");
            for (Result r : results) {
                out.println(r.toString());
            }
            out.println("------------------------------");
            out.println("Total students: " + results.size());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}