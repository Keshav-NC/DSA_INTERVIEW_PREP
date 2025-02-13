package com.keshav.SDE.LeetDaily;

import java.util.PriorityQueue;

public class MaximumSumWithEqualsDigitsSum {
    public static void main(String[] args) {
        int[] nums = {368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183};
        System.out.println(maximumSum(nums));
    }

    private static int maximumSum(int[] nums) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int num : nums) { // O(n)
            int sum = 0;
            int temp = num;
            while (num > 0) { // log(n)
                sum += num % 10;
                num /= 10;
            } // nlog(n)
            maxHeap.offer(new int[]{sum, temp});
        }
        int ans = -1;
        while (maxHeap.size() >= 2) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.peek();
            if (first[0] == second[0]) {
                ans = Math.max(ans, first[1] + second[1]);
            }
        }
        return ans;
    }
}
