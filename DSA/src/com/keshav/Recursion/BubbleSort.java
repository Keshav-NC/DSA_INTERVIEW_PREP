package com.keshav.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort (int[] nums, int lastIndex, int curIndex) {

        if (lastIndex == 0) {
            return;
        }
        if (curIndex < lastIndex) {
            if (nums[curIndex] > nums[curIndex+1]) {
                // swap
                int temp = nums[curIndex];
                nums[curIndex] = nums[lastIndex];
                nums[lastIndex] = temp;
            }
            sort(nums, lastIndex, ++curIndex);
        } else {
            sort(nums, --lastIndex, 0);
        }
    }
}
