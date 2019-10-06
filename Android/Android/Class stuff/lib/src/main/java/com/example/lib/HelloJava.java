package com.example.lib;

public class HelloJava {
    public static void main (String[] args) {
        System.out.println("Welcome to Java Programming");
        System.out.println("\\hello\nhow\tare \"you\"");
        System.out.println('\n');
        System.out.println("/ \\ // \\\\ /// \\\\\\");
        System.out.println("This program prints a\nquote from the Gettysburg Address.\n\n\"Four score and seven years ago,\nour 'fore fathers' brought forth on\nthis continent a new nation.\"\n");
        System.out.println("A \"quoted\" String is\n'much' better if you learn\nthe rules of \"escape sequences.\"\n\nAlso,\"\" represents an empty String.\nDon't forget: use\\\" instead of \" !\n''is not the same as \"\n\n");
        System.out.printf("%s %d %s\n\n", "I have", 5, "apples");

        String stringVal = "Welcome to Java Programming";
        System.out.printf("%.5s\n", stringVal);
    }
}
