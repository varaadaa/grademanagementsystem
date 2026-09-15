package com.gradeapp.ui;

import com.gradeapp.model.Result;
import com.gradeapp.service.GradeService;
import com.gradeapp.util.FileLogger;
import com.gradeapp.util.InputValidator;

import java.util.List;
import java.util.Scanner;

/**
 * Console UI: menu-driven.
 */
public class Main {
    private static GradeService service = new GradeService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Student Grade Management System ===");
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handleViewAll();
                    break;
                case 3:
                    handleTopper();
                    break;
                case 4:
                    handleSaveReport();
                    break;
                case 5:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n1. Add Student Result");
        System.out.println(2 + ". View All Results");
        System.out.println("3. View Topper");
        System.out.println("4. Save Report to File");
        System.out.println("5. Exit");
    }

    private static void handleAddStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();
        if (!InputValidator.validName(name)) {
            System.out.println("Invalid name.");
            return;
        }

        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine().trim();
        if (!InputValidator.validRoll(roll)) {
            System.out.println("Invalid roll number.");
            return;
        }

        int m1 = readInt("Enter marks for Subject 1 (0-100): ");
        int m2 = readInt("Enter marks for Subject 2 (0-100): ");
        int m3 = readInt("Enter marks for Subject 3 (0-100): ");

        if (!InputValidator.validMark(m1) || !InputValidator.validMark(m2) || !InputValidator.validMark(m3)) {
            System.out.println("One or more marks are invalid. Each must be 0-100.");
            return;
        }

        service.addResult(name, roll, m1, m2, m3);
        System.out.println("Result added successfully!");
    }

    private static void handleViewAll() {
        List<Result> all = service.getAllResults();
        if (all.isEmpty()) {
            System.out.println("No results yet.");
            return;
        }
        System.out.println("\n--- All Results ---");
        for (Result r : all) {
            System.out.println(r.toString());
        }
    }

    private static void handleTopper() {
        Result top = service.getTopper();
        if (top == null) {
            System.out.println("No results yet.");
            return;
        }
        System.out.println("\nTopper:");
        System.out.println(top.toString());
    }

    private static void handleSaveReport() {
        List<Result> all = service.getAllResults();
        if (all.isEmpty()) {
            System.out.println("No results to save.");
            return;
        }
        boolean ok = FileLogger.saveReport(all);
        if (ok) System.out.println("Report saved to class_report.txt");
        else System.out.println("Failed to save report.");
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Invalid input. Enter an integer.");
            }
        }
    }
}