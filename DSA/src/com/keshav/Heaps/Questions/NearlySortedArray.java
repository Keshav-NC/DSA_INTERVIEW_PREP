package com.keshav.Heaps.Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
        int k = 2;
        System.out.println(Arrays.toString(sort(arr, k)));
    }

    private static int[] sort(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // minHeap
        int index = 0;
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                arr[index++] = (minHeap.isEmpty() ? 0 : minHeap.poll());
            }
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
        return arr;
    }
}
