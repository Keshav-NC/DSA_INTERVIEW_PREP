package com.keshav.SDE.LeetDaily;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximunScoreKOperations {
    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(maxScore(nums, k));
    }

    private static long maxScore (int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        System.out.println(maxHeap);
        long score = 0;
        for (int i = 0; i < k; ++i) {
            int max = maxHeap.poll();
            score += max;
            maxHeap.offer((int)(Math.ceil((double) max /3)));
        }
        System.out.println(maxHeap);
        return score;
    }
}
