package com.keshav.Trees;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Student implements Comparable<Student> {
    int usn;
    int marks;
    String name;

    Student(int usn, int marks, String name) {
        this.usn = usn;
        this.marks = marks;
        this.name = name;
    }

    @Override
    public int compareTo(Student that) {
        if (that.marks == this.marks) {
            return this.usn - that.usn; // inc usn
        }
        if (that.usn == this.usn) {
            return this.name.compareTo(that.name); // lex order
        }
        return that.marks - this.marks; // dec marks
//        return this.usn - that.usn;// inc usn
    }

    public String toString() {
        return "Student : " + this.name;
    }
}
public class MyTreeMap {
    public static void main(String[] args) {
//        TreeMap<Integer, Integer> tMap = new TreeMap<>(Collections.reverseOrder()); // default -> ascending sort
//        // key --> sorted
//        tMap.put(5, 1);
//        tMap.put(4, 2);
//        tMap.put(10, 3);
////        System.out.println(tMap);
//        for (Map.Entry<Integer, Integer> e : tMap.entrySet()) {
//            System.out.print("Key -> " + e.getKey());
//            System.out.println(" ,Value -> " + e.getValue());
//        }
//        TreeMap<Student, Integer> tMap = new TreeMap<>();
//        tMap.put(new Student(60, 90, "Priya"), 5);
//        tMap.put(new Student(60, 80, "Keshav"), 3);
//        tMap.put(new Student(70, 100, "Saket"), 6);
//        tMap.put(new Student(70, 100, "Esha"), 6);
//
//        Student std = new Student(70, 100, "Saket");
//        System.out.println(tMap.containsKey(std));
//
//
//////        System.out.println(tMap);
////        for (Map.Entry<Student, Integer> e : tMap.entrySet()) {
////            System.out.print("Key -> " + e.getKey());
////            System.out.println(" ,Value -> " + e.getValue());
////        }

        TreeMap<Integer, Integer> tMap2 = new TreeMap<>();
        tMap2.put(4, 2);
        tMap2.put(3, 5);
        tMap2.put(1, 9);
        tMap2.put(8, 4);
        tMap2.put(2, 1);
        tMap2.put(6, 4);
        System.out.println(tMap2.floorKey(5));
        System.out.println(tMap2.ceilingKey(5));
        System.out.println(tMap2.ceilingEntry(5));
        System.out.println(tMap2.firstKey());
        System.out.println(tMap2.lastKey());

    }
}
