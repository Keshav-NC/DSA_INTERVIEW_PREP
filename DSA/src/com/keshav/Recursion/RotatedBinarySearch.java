package com.keshav.Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(search(nums, 0, 0, nums.length-1));
    }

    static int search (int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        // case1 --> left side of the array is sorted
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return search(nums, target, start, mid - 1);
            } else {
                return search(nums, target, mid + 1, end);
            }
        }
        // case2 --> check rhs
        if (nums[mid] > nums[end] && target >= nums[mid] && target < nums[end]) {
            return search(nums, target, mid + 1, end);
        }
        // case3
        return search(nums, target, start, mid-1);
    }
}
