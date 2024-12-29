package com.keshav.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSumOfDistinctSubarray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    private static int maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long maxSum = 0, currSum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            // add to currSum and add to set
            currSum += nums[end];

            // if current num present in set or window size exceeds given window size
            while (set.contains(nums[end]) || (end - start + 1) > k) {
                currSum -= nums[start];
                set.remove(nums[start]);
                ++start;
            }
            // add the number after removing issues
            set.add(nums[end]);

            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum,currSum);
            }
        }
        return (int)maxSum;
    }
}
