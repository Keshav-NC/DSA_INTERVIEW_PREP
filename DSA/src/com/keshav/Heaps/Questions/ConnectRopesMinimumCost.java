package com.keshav.Heaps.Questions;

import java.util.PriorityQueue;

public class ConnectRopesMinimumCost {
    public static void main(String[] args) {
        int[] ropes = {1, 2, 3, 4, 5};
        System.out.println(minimum(ropes));
    }

    public static int minimum (int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;
        System.out.println(minHeap);
        // min two
        while (minHeap.size() >= 2) {
            int cost = 0;
            for (int i = 0; i < 2; i++) {
                cost += minHeap.poll() ;
            }
            minHeap.offer(cost);
            totalCost += cost;
        }
        System.out.println(totalCost);

        return 0;
    }
}
