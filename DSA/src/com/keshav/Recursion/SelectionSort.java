package com.keshav.Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 1, 10, 9};
        sort2(nums, 0, nums.length - 1, 0);
        System.out.println(Arrays.toString(nums));
    }

    static void sort1 (int[] nums, int lastIndex) {
        if (lastIndex == 0) {
            return;
        }
        int maxIndex = getMaxIndex(nums, lastIndex);
        swap(nums, maxIndex, lastIndex);
        sort1(nums, --lastIndex);

    }

    static void sort2 (int[] nums, int curIndex, int lastIndex, int max) {
        if (lastIndex == 0) {
            return;
        }

        if (curIndex < lastIndex) {
            if (nums[curIndex] > nums[max]) {
                sort2(nums, ++curIndex, lastIndex, curIndex);
            } else {
                sort2(nums, ++curIndex, lastIndex, max);
            }
        } else {
            swap(nums, lastIndex, max);
            sort2(nums, 0, --lastIndex, 0);
        }
    }

    static int getMaxIndex (int[] nums, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap (int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}
