package com.keshav.Stacks;

public class CIRCULARQUEUE {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    private int size = 0;

    public CIRCULARQUEUE() {
        this(DEFAULT_SIZE);
    }

    public CIRCULARQUEUE(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is Full!");
        }
        data[end++] = item;
        end %= data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }
        int removed = data[front++];
        front %= data.length;
        size--;
        return removed;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!!");
        }
        int i = front;
        do {
            System.out.println(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");
    }
}
