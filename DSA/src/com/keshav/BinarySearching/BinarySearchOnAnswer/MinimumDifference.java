package com.keshav.BinarySearching.BinarySearchOnAnswer;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 12, 15};
        int target = 1;
        System.out.println(minimumDifference(nums, target));
    }

    private static int minimumDifference(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        if (lb == -1) {
            return Math.abs(target - nums[ub]);
        }
        if (ub == -1) {
            return Math.abs(target - nums[lb]);
        }
        return Math.min( Math.abs(target - nums[lb]), Math.abs(target - nums[ub]));
    }
    private static int lowerBound(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private static int upperBound(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
