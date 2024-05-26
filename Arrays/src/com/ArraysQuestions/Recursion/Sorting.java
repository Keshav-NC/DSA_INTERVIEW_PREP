package com.ArraysQuestions.Recursion;

public class Sorting {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sort(nums));
    }

    static boolean sort (int[] nums) {
        return helper (nums, 0);
    }

    static boolean helper (int[] nums, int i) {
        // base condition
        if (i == nums.length-1) {
            return true;
        }
        return nums[i] < nums[i+1] && helper(nums, ++i);
    }


}
