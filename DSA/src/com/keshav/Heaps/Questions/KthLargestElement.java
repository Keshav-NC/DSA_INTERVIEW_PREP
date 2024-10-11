package com.keshav.Heaps.Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 2;
        System.out.println(largest(arr, k));
    }

    private static int largest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
        }
        System.out.println(minHeap);
        return minHeap.poll();
    }
}
