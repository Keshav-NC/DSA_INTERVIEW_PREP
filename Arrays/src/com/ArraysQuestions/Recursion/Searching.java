package com.ArraysQuestions.Recursion;

public class Searching {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 9};
        int target = 9000;
        System.out.println(search(nums, target));
    }

    static int search (int[] nums, int target) {
        return helper (nums, target, 0) ;
    }

    static int helper (int[] nums, int target, int index) {
        if (index > nums.length - 1) {
            return -1;
        }

        if (nums[index] == target) {
            return index;
        }
        return target != nums[index] && helper(nums, target, ++index);
    }
}
