package com.keshav.Heaps.Questions;

import javax.swing.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int k = 3;
        System.out.println(smallestElement(arr, k));
    }

    /**
     *
     * Note : minHeap or maxHeap
     * 1) kth smallest / largest
     * 2) sorting
     * 3) NlogN to NlogK
     * 4) smallest element --> use maxHeap --> Collections.reverseOrder()
     * 5) largest element --> use minHeap --> default
     */

    private static int smallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for (int num : arr) {
            maxHeap.offer(num);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
        }
        System.out.println(maxHeap);
        return (maxHeap.isEmpty() ? -1 : maxHeap.peek());
    }
}
