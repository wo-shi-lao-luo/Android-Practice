package com.example.lib;

import java.util.Scanner;

public class week3_3{
    public static class weel3_3 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("First number: ");
            int n1 = input.nextInt();
            System.out.print("Second number: ");
            int n2 = input.nextInt();
            System.out.print("Final number: ");
            int n3 = input.nextInt();
            System.out.printf("The mean of 3 numbers is: %f\n", (float) (n1 + n2 + n3) / 3);

        }
    }
}
