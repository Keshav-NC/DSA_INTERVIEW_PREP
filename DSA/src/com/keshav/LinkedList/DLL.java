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

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = null;
        }
        head = node;

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

    // deletion at last
    public int deleteLast () {
        int value = tail.next.value;
        if (size <= 1) {
            return deleteFirst();
        }
        tail = tail.prev;
        tail.next = null;

        size--;
        return value;
    }

    // deletion at particular index
    public int delete (int index) {
        Node temp = get(index);
        int value = temp.next.value;

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }


        size--;
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

    // get the reference at a particular node
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        size--;
        return temp;
    }

    // insert after the given value
    public void insertAfter(int value, int afterValue) {
        Node p = find(afterValue);
        if (p == null) {
            System.out.println("Does not exist");
            return;
        }

        Node node = new Node(value);

        node.next = p.next;
        p.next = node;
        node.prev = p;

        if (node.next != null) {
            node.next.prev = node;
        }
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
