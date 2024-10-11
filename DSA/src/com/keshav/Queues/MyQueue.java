package com.keshav.Queues;

public class MyQueue {
    int front;
    int rear;
    int[] queue;
    int capacity;
    int size;

    public MyQueue(int capacity) {
        queue = new int[capacity];
        this.capacity = capacity;
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int size() {
        return size;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear++;
        }
        queue[rear] = val;
        ++size;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = queue[front];
        if (front == rear) { // last value --> after delete
            front = rear = -1;
        } else {
            front++; // delete
        }
        size--;
        return val;
    }

    public void print() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        queue.dequeue();
        queue.print();
        System.out.println(queue.size());
        queue.dequeue();
        queue.print();
        System.out.println(queue.size());
        queue.enqueue(8);
    }
}
