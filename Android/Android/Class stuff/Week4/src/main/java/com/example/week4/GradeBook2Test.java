package com.example.week4;
import java.util.*;

public class GradeBook2Test {

    public static void main(String[] args) {
        GradeBook2 gb1 = new GradeBook2();
        GradeBook2 gb2 = new GradeBook2();
        gb1.setCourseName("Mobile Computing");
        gb2.setCourseName("Foundation of AI");
        gb1.display();
        gb2.display();
    }
}
