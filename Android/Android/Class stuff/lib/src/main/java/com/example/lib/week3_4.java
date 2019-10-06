package com.example.lib;

public class week3_4 {
    public static void main(String[] args) {
        int count = 0;
        int start = 0;
        while (true) {
            if (count == 10) break;
            int result = (start + 10) % 7;
            if (result == 5) {
                count ++;
                System.out.println(start);
                start++;
            }
            else start++;
        }
    }
}
