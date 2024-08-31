package com.keshav.LinkedList;

public class DoublyLL {
    public static void main(String[] args) {
        DLL list = new DLL();
        // insertion at first
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insertFirst(60);

        // insertion at last
        list.insertLast(0);

        // insertion at particular index
        list.insert(30, 3);
        list.insertAfter(35, 10);

        list.display();

        // deletion at first
//        System.out.println(list.deleteFirst() + " deleted");

        // deletion at last
//        System.out.println(list.deleteLast() + " deleted");

        // deletion at particular index
//        System.out.println(list.delete(2) + " deleted");

        list.display(); // 60 50 ..... 10
    }
}
