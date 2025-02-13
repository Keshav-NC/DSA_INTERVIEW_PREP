package com.keshav.SDE.LeetDaily;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NoOfWaysSplitArray {
    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }

    private static int waysToSplitArray(int[] nums) {
        long left = 0;
        long right = Arrays.stream(nums).asLongStream().sum();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                ++count;
            }
        }
        return count;
    }
}
