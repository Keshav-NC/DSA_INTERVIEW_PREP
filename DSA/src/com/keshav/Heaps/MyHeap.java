package com.keshav.Heaps;

import java.util.Arrays;

public class MyHeap {
    int[] heap;
    int heapSize;
    int capacity;


    public MyHeap(int[] arr) {
        this.heap = arr;
        this.heapSize = arr.length;
        this.capacity = arr.length;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void increaseCapacity() {
        // double the capacity size
        capacity *= 2;
        // create new array of capacity size
        int[] newHeap = new int[capacity];
        newHeap = Arrays.copyOf(heap, capacity);
        heap = newHeap;
    }

    // max heap
    public void heapify(int index) {
        int largest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        // current node must be greater than of its left child and right child
        // if not, then swap it
        if (leftChildIndex < heapSize && heap[largest] < heap[leftChildIndex]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && heap[largest] < heap[rightChildIndex]) {
            largest = rightChildIndex;
        }
        // current node > leftChild --> stop
        // current node > rightChild --> stop
        // current node == leaf node --> stop
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    public void buildTree() {
        // leaf nodes -> [N/2 , (N-1)] --> already balanced --> don't apply heapify on them

        // apply heapify from [((N/2) - 1), 0]
        for (int index = heapSize/2 - 1; index >= 0; index--) {
            heapify(index);
        }
    }

    public int peek() {
        if (heapSize < 0){
            return -1;
        }
        return heap[0];
    }

    public int extractMax() {
        if (heapSize < 0) {
            return -1;
        }
        int max = heap[0];
        swap(0, heapSize-1);
        heapSize--;
        heapify(0);
        return max;
    }

    public void increaseKey(int index, int newVal) {
        if (index < 0 || index > heapSize || heap[index] >= newVal) {
            System.out.println("Wrong operation");
            return;
        }
        heap[index] = newVal;
        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index/2.0) - 1)]) {
            swap(index, (int) (Math.ceil(index/2.0) - 1));
            index = (int) (Math.ceil(index/2.0) - 1);
        }
    }

    public void decreaseKey (int index, int newVal) {
        if (index < 0 || index > heapSize || heap[index] <= newVal) {
            System.out.println("Wrong operation");
            return;
        }
        heap[index] = newVal;
        heapify(index);
    }

    public void insert(int newValue) {
        if (heapSize + 1 >= capacity) {
            increaseCapacity();
        }

        heapSize += 1;
        int index = heapSize - 1;
        heap[index] = newValue;

        while (index > 0 && heap[index] > heap[(int) (Math.ceil(index/2.0) - 1)]) {
            swap(index, (int) (Math.ceil(index/2.0) - 1));
            index = (int) (Math.ceil(index/2.0) - 1);
        }
    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 20, 6, 11};
        MyHeap heap = new MyHeap(arr);
        heap.buildTree();
        heap.print();
//        System.out.println(heap.peek());
//        heap.print();
//        System.out.println(heap.pop());
//        heap.print();
        heap.increaseKey(4, 15);
        heap.print();
        System.out.println();

        heap.decreaseKey(0, 4);
        heap.print();

        heap.print();
        heap.insert(18);
        heap.print();

    }
}
