package com.ArraysQuestions.Recursion;

public class BSRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7, 55, 66, 88};
        int target = 7;
        System.out.println(bsRec(nums, target, 0, nums.length-1));
    }
    //                                                              comparing   Dividing arr into half
    // Recurrence relation of BinarySearch using Recursion --> BS(N) = O(1)   +    BS(N/2).
    static int bsRec (int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;

        }
        int mid = start + (end-start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return bsRec(nums, target, mid+1, end);
        }
        return bsRec(nums, target, start, mid-1);
    }

}
