package com.ArraysQuestions.BinarySearching;

public class BSCeil {
    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 7, 67, 89, 90};
        int target = 65;
        int ans = ceilBS(nums, target);
        System.out.println(nums[ans]);
    }
    static int ceilBS(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        boolean isAsc = nums[start] < nums[end];

        while (start<=end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) return mid;
            else if (isAsc) {
                if (target < nums[mid]) end = mid - 1;
                else if (target > nums[mid]) start = mid + 1;
            } else {
                if (target > nums[mid]) end = mid + 1;
                else if (target < nums[mid]) start = mid - 1;
            }
        }
    return start; //break of while condition
    }
}
