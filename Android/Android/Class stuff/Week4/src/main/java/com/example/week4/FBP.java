package com.example.week4;

public class FBP {
    private String name;
    private String age;

    public void setName(String FBPname) {
        name = FBPname;
    }

    public void setAge(String FBPage) {
        age = FBPage;
    }

    public void run() {
        System.out.println(name + " is running");
    }

    public void jump() {
        System.out.println(name + " is jumping");
    }
}
