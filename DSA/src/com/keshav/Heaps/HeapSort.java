package com.keshav.Heaps;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 18, 20, 30};
        MyHeap myHeap = new MyHeap(arr);
        myHeap.buildTree();
        int lastIndex = myHeap.heapSize - 1;
        while (lastIndex > 0) {
            int max = myHeap.extractMax();
            myHeap.heap[lastIndex] = max;
            lastIndex--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
