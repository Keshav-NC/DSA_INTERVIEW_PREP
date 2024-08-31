package com.keshav.LinkedList;

public class CircularLL {
    public static void main(String[] args) {
        CLL list = new CLL();

        list.insertLast(40);
        list.insertLast(30);
        list.insertLast(20);
        list.insertLast(10);
        list.insertFirst(0);
        list.insertFirst(50);
        list.display();
        list.delete(20);
//        System.out.println(list.deleteFirst());
//        System.out.println(list.find(30));
        list.display();
    }
}
