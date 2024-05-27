package com.ArraysQuestions.Recursion;

public class Searching {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 9};
        int target = 9;
        System.out.println(search(nums, target));
    }

    static boolean search (int[] nums, int target) {
        return helperBool (nums, target, 0) ;
    }

    static boolean helperBool (int[] nums, int target, int index) {
        if (index == nums.length) {
            return false;
        }

        if (nums[index] == target) {
            return true;
        }
        return nums[index] != target && helperBool(nums, target, ++index);
    }

    static int helperInt (int[] nums, int target, int index) {
        if (index == nums.length) {
            return -1;
        }

        if (nums[index] == target) {
            return index;
        }
        return helperInt(nums, target, ++index);
    }
}
