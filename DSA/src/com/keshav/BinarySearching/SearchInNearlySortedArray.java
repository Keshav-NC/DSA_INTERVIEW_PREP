package com.keshav.BinarySearching;

public class SearchInNearlySortedArray {
    // Given a sorted array arr[] of size n, some elements of array are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1]. The task is to search for an element in this array.
    public static void main(String[] args) {
        int[] nums = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If the element is present at
            // one of the middle 3 positions
            if (nums[mid] == target) {
                return mid;
            } else if (mid - 1 >= start && nums[mid - 1] == target) {
                return mid - 1;
            } else if (mid + 1 < end && nums[mid + 1] == target) {
                return mid + 1;
            } else if (nums[mid] > target) { // left
                end = mid - 2;
            } else { // right
                start = mid + 2;
            }
        }
        return -1;
    }
}
