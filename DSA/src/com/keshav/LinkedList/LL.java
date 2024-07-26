package com.keshav.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    // insertion at the very first or head
    public void insertFirst(int value) {
        Node node = new Node(value); // creating new node
        node.next = head; // point the address of new node to head
        head = node; // point head to new node

        if (tail == null) {
            tail = head; // both points to same node
        }
        size++;
    }

    // insertion at the very last
    public void insertLast(int value) {
        Node node = new Node(value); // creating new node
        // list is empty, call insertFirst
        if (tail == null) {
            insertFirst(value);
            return;
        }

        tail.next = node; // point the address of last(tail) node to new node
        tail = node; // point tail to new node

        size++;
    }

    // insertion at particular index
    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head; // 0
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

//        Node node = new Node(value);
//        node.next = temp.next;
//        temp.next = node;

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    // delete at first
    public int deleteFirst () {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    // delete at last
    public int deleteLast () {
        int value = tail.value;
        if (size <= 1) {
            deleteFirst();
        }

        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
        return  value;
    }

    // delete at particular index
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node temp = get(index - 1);
        int value = temp.next.value;
        temp.next = temp.next.next;


        return value;
    }

    // find the node for the particular value
    public Node find (int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null; // not found
    }

    // get the reference of a particular node
    public Node get (int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    class Node {
        private int value;
        private Node next; // by default, it points to null

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
