package com.gradeapp.model;

/**
 * Stores marks and computed total, percentage and grade for a student.
 */
public class Result {
    private Student student;
    private int mark1;
    private int mark2;
    private int mark3;
    private int total;
    private double percentage;
    private String grade;

    public Result(Student student, int mark1, int mark2, int mark3) {
        this.student = student;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        compute();
    }

    private void compute() {
        this.total = mark1 + mark2 + mark3;
        this.percentage = (total / 3.0);
        this.grade = calculateGrade(this.percentage);
    }

    private String calculateGrade(double percent) {
        if (percent >= 90) return "A+";
        if (percent >= 80) return "A";
        if (percent >= 70) return "B";
        if (percent >= 60) return "C";
        if (percent >= 50) return "D";
        return "F";
    }

    public Student getStudent() { return student; }
    public int getMark1() { return mark1; }
    public int getMark2() { return mark2; }
    public int getMark3() { return mark3; }
    public int getTotal() { return total; }
    public double getPercentage() { return percentage; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("%s | Marks: [%d, %d, %d] | Total: %d | %%: %.2f | Grade: %s",
                student.toString(), mark1, mark2, mark3, total, percentage, grade);
    }
}