package com.keshav.Heaps;

import java.net.CookieHandler;
import java.util.Collections;
import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent> {
    String name;
    int marks;

    public NewStudent(String name, int marks) {
        this.marks = marks;
        this.name = name;
    }

    public int compareTo(NewStudent that) {
        if (this.marks == that.marks) {
            return this.name.compareTo(that.name);
        }
        return this.marks - that.marks; // asc
//        return that.marks - this.marks; // dec
    }

    public String toString() {
        return "Student Name : " + this.name + " , Marks : " + this.marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewStudent) {
            NewStudent that = (NewStudent) obj;
            if (that.marks == this.marks && that.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

public class MyPriorityQueue {
    public static void main(String[] args) {
//        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // default -> min PQ
//        minPq.offer(1);
//        minPq.offer(5);
//        minPq.offer(0);
//        minPq.offer(8);
//        minPq.offer(2);
//        System.out.println("Highest priority element in minPQ: " + minPq.peek());
//
//        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); // max PQ
//        maxPq.offer(1);
//        maxPq.offer(5);
//        maxPq.offer(0);
//        maxPq.offer(8);
//        maxPq.offer(2);
//        System.out.println("Highest priority element in maxPQ: " + maxPq.peek());

        PriorityQueue<NewStudent> pq = new PriorityQueue<>();
        NewStudent ns = new NewStudent("Keshav", 90);
        pq.offer(new NewStudent("Keshav", 90));
        pq.offer(new NewStudent("Saket", 90));
        pq.offer(new NewStudent("Esha", 90));
        pq.offer(new NewStudent("Priya", 100));
//        System.out.println(pq.peek()); // min
        System.out.println(pq.peek()); // max
//        System.out.println(pq.contains(ns));
    }
}
