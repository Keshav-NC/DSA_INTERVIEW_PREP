package com.keshav.SDE.LeetDaily;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubArrayDifference {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        System.out.println(absDiff(nums, 4));
    }

    private static int absDiff(int[] nums, int limit) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length-1 && nums[i] <= nums[i+1]) {
                count++;
            }
        }
        return count;
    }
}
