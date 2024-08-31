package com.keshav.LinkedList.Questions;

import com.keshav.LinkedList.LL;

public class Duplicates {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);

        list.display();
        list.duplicates();
        list.display();

    }


}
