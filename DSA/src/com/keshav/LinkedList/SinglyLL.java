package com.keshav.LinkedList;

public class SinglyLL {
    public static void main(String[] args) {
        LL list = new LL();
//        // insertion at first
//        list.insertFirst(3);
//        list.insertFirst(5);
//        list.insertFirst(7);
//        list.insertFirst(19);

        // insertion at last
        list.insertLast(90);
        list.insertLast(5);
        list.insertLast(7);
        list.insertLast(19);

        // insertion at particular index
        list.insert(100, 3);
        list.display();

        // delete first
//        System.out.println(list.deleteFirst() + " deleted");

        // delete last
//        System.out.println(list.deleteLast() + " deleted");

        // delete at particular index
        System.out.println(list.delete(3) + " deleted");

        list.display(); // 19 7 5 3

    }
}
