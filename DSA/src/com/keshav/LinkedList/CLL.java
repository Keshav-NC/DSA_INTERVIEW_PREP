package com.keshav.LinkedList;

public class CLL {
    private Node head;
    private Node tail;

    public void insertFirst (int value) {
        Node node = new Node(value);

        if (head == null && tail == null) {
            head = node;
            tail = node;
        }
        node.next = head;
        head = node;
        tail.next = head;
    }

    public void insertLast(int value) {
        Node node = new Node(value);

        if (head == null && tail == null) {
            insertFirst(value);
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    // find
    public Node find (int value) {
        Node node = head;

        while (node.next != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null; // not found
    }

    // delete at first
    public int deleteFirst() {

        int value = head.value;
        head = head.next;
        tail.next = head;

        return value;
    }

//    public int deleteLast () {
//        Node temp = head;
//        int value = temp.value;
//
//        while (temp.next != head) {
//
//        }
//    }

    public void delete (int value) {
        Node temp = head;
        if (temp.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = temp.next;
            if (n.value == value) {
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while (temp != head);
    }

    // display
    public void display() {
        Node temp = head;

        if (head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("END");
    }

    class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}


