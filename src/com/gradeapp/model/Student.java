package com.gradeapp.model;


	/**
	 * Stores basic student information.
	 */
	public class Student {
	    private String name;
	    private String rollNo;

	    public Student() {}

	    public Student(String name, String rollNo) {
	        this.name = name;
	        this.rollNo = rollNo;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getRollNo() {
	        return rollNo;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setRollNo(String rollNo) {
	        this.rollNo = rollNo;
	    }

	    @Override
	    public String toString() {
	        return String.format("%s (Roll: %s)", name, rollNo);
	    }
	}