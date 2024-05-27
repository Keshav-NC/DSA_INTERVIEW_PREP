package com.keshav.Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort (int[] nums, int curIndex, int nextIndex) {

        if (curIndex == 0) {
            return;
        }
        if (nextIndex < curIndex) {
            if (nums[nextIndex] > nums[++nextIndex]) {
                // swap
                int temp = nums[nextIndex];
                nums[nextIndex] = nums[curIndex];
                nums[curIndex] = temp;
            }
            sort(nums, curIndex, ++nextIndex);
        } else {
            sort(nums, --curIndex, 0);
        }
    }
}
