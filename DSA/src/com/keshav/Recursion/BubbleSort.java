package com.keshav.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort (int[] nums, int curIndex, int lastIndex) {
        // after lastIndex reaches 0th index just return
        if (lastIndex == 0) {
            return;
        }
        // check if current index is lesser than the last index
        if (curIndex < lastIndex) {
            // check if the element at correct index is greater than the element of the next index, if true then swap it with that element
            if (nums[curIndex] > nums[curIndex+1]) {
                // swap
                int temp = nums[curIndex];
                nums[curIndex] = nums[curIndex+1];
                nums[curIndex+1] = temp;
            }
            // after swap, decrement the last index, repeat the above steps
            sort(nums, ++curIndex, lastIndex);
        } else {
            sort(nums, 0, --lastIndex);
        }
    }
}
