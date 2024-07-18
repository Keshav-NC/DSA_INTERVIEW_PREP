package com.keshav.OOPS;

import java.sql.Struct;

public class Classes {
    public static void main(String[] args) {

        // create data of 5 students {rollno, name, marks}
        int[] numbers = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

//        Student s1; // declaration
//        s1 = new Student(); // initialization
        Student s1 = new Student(); // declaration + initialisation

//        System.out.println(s1);

//        System.out.println(s1.rno);
//        System.out.println(s1.name);
//        System.out.println(s1.marks);

//        s1.rno = 60;
//        s1.name = "Keshav";
//        s1.marks = 88f;
//
//        System.out.println(s1.rno);
//        System.out.println(s1.name);
//        System.out.println(s1.marks);


        Student s2 = new Student(107, "Priya", 99);
        System.out.println(s2.rno);

    }
}
// create class
// for every student

class Student {
    int rno;
    String name;
    float marks;

//    Student () {
//        s1.rno = 60;
//        s1.name = "Keshav";
//        s1.marks = 88f;
//    }

    // we need a way to add the value to the above properties object by object
    // we need one word to access every object --> this


    // here keyword "this" will be replaced with s1
    // constructor with no parameters
    Student () {
        this.rno = 60;
        this.name = "Keshav";
        this.marks = 88.8f;
    }

    Student (int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }
}
