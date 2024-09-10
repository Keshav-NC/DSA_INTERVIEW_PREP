package com.keshav.Stacks;

public class QUEUE {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public QUEUE() {
        this(DEFAULT_SIZE);
    }

    public QUEUE(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is Full!");
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty!!");
        }
        int removed = data[0];

        //shift the elements to left
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!!");
        }
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}
