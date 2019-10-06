package com.example.week4;

import java.util.*;

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GradeBook gb = new GradeBook();

        System.out.println("Enter 2 numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.printf("The sum of two number is %d", gb.addition(a, b));


        System.out.println("Please Enter Course Name:");
        String courseName = input.nextLine();
        gb.display(courseName);


    }
}
