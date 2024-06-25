package com.keshav.BinarySearching.BinarySearchOnAnswer;

public class UpperBound {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 6, 7, 8 ,8, 11, 11, 11, 12};
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(upperBound(nums, target));
    }
    // Upper Bound, smaller index such that arr[index] > target
    // TC --> O(log N)
    private static int upperBound(int[] nums, int target) {
        int ans = nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // maybe an ans, go check the smaller index
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
