package com.gradeapp.util;

/**
 * Basic input validation utilities for names, roll no and marks.
 */
public class InputValidator {

    public static boolean validName(String name) {
        return name != null && !name.trim().isEmpty() && name.trim().length() <= 80;
    }

    public static boolean validRoll(String roll) {
        return roll != null && !roll.trim().isEmpty() && roll.trim().length() <= 20;
    }

    public static boolean validMark(int mark) {
        return mark >= 0 && mark <= 100;
    }
}