package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 0, 2};
        System.out.println(Arrays.toString(sortColor(nums)));
    }

    private static int[] sortColor(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int[] ans = new int[nums.length];

        while (start != end) {
            if (nums[start] == 0) {
                ans[start] = 0;
                start++;
            }

            if (nums[end] == 2) {
                ans[end] = 2;
                end--;
            }
        }
        nums = ans;
        return nums;
    }
}
