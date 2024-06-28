package com.keshav.BinarySearching;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 4, 2, 1};
        int target = 2;

        System.out.println(search(nums, target));

    }

    static int search (int[] nums, int target) {
        int peak = peakIndexInMountainArray(nums);
        int firstTry = orderAgnosticBS(nums, target, 0, peak);

        //search in first half --> Asc
        if (firstTry != -1) return firstTry;

        //search in second half --> Desc

        return orderAgnosticBS(nums, target, peak+1, nums.length-1);

    }

    static int peakIndexInMountainArray (int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int mid = start + (end-start) / 2;

            if (nums[mid] > nums[mid+1]) end = mid;
            else start = mid+1;
        }
        return start;
    }

    static int orderAgnosticBS (int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end-start) / 2;
            boolean isAsc = nums[start] < nums[end];
            if (target == nums[mid]) return mid;
            else if (isAsc) {
                if (target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}
