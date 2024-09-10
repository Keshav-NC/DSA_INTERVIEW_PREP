package com.keshav.Stacks;

public class STACK {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public STACK() {
        this(DEFAULT_SIZE);
    }

    public STACK(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == data.length - 1; // ptr at last index
    }

    public boolean isEmpty() {
        return ptr == -1; // ptr at -1 index means empty condition
    }

    public boolean push(int item) throws Exception{
        if (isFull()) {
            throw new Exception("Stack is Full!!");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty stack!!");
        }
//        int value = data[ptr];
//        ptr--;
//        return value;
        return data[ptr--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty stack!!");
        }
        return data[ptr];
    }
}
