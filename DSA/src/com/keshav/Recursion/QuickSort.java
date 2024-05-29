package com.keshav.Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort (int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;

        // considering pivot as middle element
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        // also a reason why if its already sorted it will not swap
        while (start <= end) {
            // if the lhs of the array is sorted just increment the start by 1
            while (nums[start] < pivot) {
                start++;
            }

            // if the rhs of the array is sorted just decrement the end by 1
            while (nums[end] > pivot) {
                end--;
            }
            // swap only if start is less than the end
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        //now pivot is at correct index, just sorted the two halves now
        sort(nums, low, end);
        sort(nums, start, high);
    }
}
