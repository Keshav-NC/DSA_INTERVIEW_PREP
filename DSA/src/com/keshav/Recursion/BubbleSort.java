package com.keshav.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort (int[] nums, int curIndex, int lastIndex) {

        if (lastIndex == 0) {
            return;
        }
        if (curIndex < lastIndex) {
            if (nums[curIndex] > nums[curIndex+1]) {
                // swap
                int temp = nums[curIndex];
                nums[curIndex] = nums[curIndex+1];
                nums[curIndex+1] = temp;
            }
            sort(nums, ++curIndex, lastIndex);
        } else {
            sort(nums, 0, --lastIndex);
        }
    }
}
