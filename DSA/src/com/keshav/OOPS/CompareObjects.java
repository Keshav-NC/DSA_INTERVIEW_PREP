package com.keshav.OOPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SStudent {
    String name;
    int marks;

    SStudent(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + " , Marks : " + this.marks;
    }
}

public class CompareObjects {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(90);
        arr.add(101);
        arr.add(95);
        arr.add(30);
        arr.add(10);
        arr.add(52);
//        System.out.println("Without sort : " + arr);
//        Collections.sort(arr); // sorting on objects
//        System.out.println("By sort : " + arr);
        // Custom sort on objects
        // now sort base on the following conditions
        //  - sort based on unit digit --> 10 , 21 --> 9%10 = 0, 11%10 = 1 --> [11, 9]
        //  - if equal than sort in increasing order

        /*
        // sorting on integers
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int unit1 = a%10;
                int unit2 = b%10;

                // if 1 or +ve --> swap
                // if 0 or -1 or -ve --> no swap
//                if (unit1 < unit2) {
//                    return -1; // already sorted
//                } else if (unit1 > unit2) {
//                    return 1; // swap
//                } else { // equal condition
//                    if (a > b) {
//                        return 1; // swap
//                    } else {
//                        return -1;
//                    }
//                }
                if (a > b) {
                    return a - b; // if +ve swap, if -ve no swap
                }
//                return unit2 - unit1; // if +ve swap, if -ve no swap --> decreasing
//                return unit1 - unit2; // if +ve swap, if -ve no swap --> increasing
            }
        };
        arr.sort(compare);
        System.out.println(arr);
        */

        // sort on class
        ArrayList<SStudent> sArr = new ArrayList<>();
        SStudent student1 = new SStudent("Keshav", 99);
        SStudent student2 = new SStudent("Priya", 100);
        SStudent student3 = new SStudent("Esha", 100);
        SStudent student4 = new SStudent("Saket", 95);
        sArr.add(student1);
        sArr.add(student2);
        sArr.add(student3);
        sArr.add(student4);

        Comparator<SStudent> compare = new Comparator<SStudent>() {
            @Override
            public int compare(SStudent s1, SStudent s2) {
                if (s1.marks == s2.marks) { // if marks are same, then sort based on their lexical order
                    return s1.name.compareTo(s2.name);
                }
                return s1.marks - s2.marks; // --> increasing order
//                return s2.marks - s1.marks; // if +ve swap, -ve no swap --> decreasing order
            }
        };
        sArr.sort(compare);
        for (SStudent student : sArr) {
            System.out.println(student);
        }
    }
}
