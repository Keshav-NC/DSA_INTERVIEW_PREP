package com.keshav.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    /*
        pivot: choose any element, after first pass
        every element < pivot, should be at lhs of pivot,
        element > pivot, should be at rhs of pivot.
    */
    /*
        How to pick pivot?
            - random element
            - corner element
            - middle element
     */
    // low & high -> for figuring which part of the array we are working on
    // start & end -> for swap (violation)
    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start <= end) {
            while (nums[start] < pivot) ++start;
            while (nums[end] > pivot) --end;

            // violation
            if (start <= end) {
                // swap
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                ++start;
                --end;
            }
        }
        // now pivot is at correct index, check two halves
        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }
}
