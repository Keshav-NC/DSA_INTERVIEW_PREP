package com.keshav.LinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int size = 0;

    public DLL() {
        this.size = 0;
    }

    // insertion at first
    public void insertFirst (int value) {
        Node node = new Node(value);

        if (tail == null) {
            tail = head;
        }

        node.next = head;
        head = node;
        head.prev = null;

        size++;
    }

    // insertion at last
    public void insertLast (int value) {
        Node node = new Node(value);
        if (tail == null) {
            insertFirst(value);
            return;
        }
        node.prev = tail;
        tail.next = node;

        size++;
    }

    // insertion at particular index
    public void insert (int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size - 1) {
            insertLast(value);
            return;
        }
        Node temp = get(index);
        Node node = new Node(value);
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
//        Node node = new Node(value, temp.next, temp);
//        temp.next = node;

        size++;
    }

    // deletion at first
    public int deleteFirst () {
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return value;
    }

    // get the reference at a particular node
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        size--;
        return temp;
    }

    // deletion at last
    public int deleteLast () {
        int value = tail.value;
        if (size <= 1) {
            deleteFirst();
            return value;
        }
        tail = tail.prev;
        tail.next = null;

        size--;
        return value;
    }

    // display
    public void display () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    class Node {
        private int value;
        private Node next; // points to next node
        private Node prev; // points to prev node

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
