package com.example.week4;

public class GradeBook2 {
    private String courseName;

    public void setCourseName(String course) {
        courseName = course;
    }

    public String getCourseName() {
        return courseName;
    }

    public void display() {
        System.out.println("Welcome to Gradebook!\n" + courseName);
    }
}
