package com.keshav.SlidingWindow;

public class MaxSumOfK {
    public static void main(String[] args) {
        // Q -> return the maximum sum of subarray of window size k
        int[] nums = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        System.out.println(maxSum(nums, k));
    }
    public static int maxSum (int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 1;
        int max = Integer.MIN_VALUE;
        int sum = nums[start];
        while (end < n) {
            sum += nums[end];
            if (end - start + 1 < k) { // get till the k
                end++;
                continue;
            } else { // eliminate first element of current window and add the next element to the window
                max = Math.max(sum, max);
                sum -= nums[start]; // eliminate
                start++;
                end++; // for adding next element into the window
            }
        }
        return max;
    }
}
