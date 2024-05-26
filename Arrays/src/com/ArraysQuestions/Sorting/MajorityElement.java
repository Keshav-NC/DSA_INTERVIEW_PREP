package com.ArraysQuestions.Sorting;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        sort (nums);
        System.out.println(Arrays.toString(nums));
//        System.out.println(nums[(nums.length-1)/2]);
    }

    static void sort (int[] nums) {
        for (int i=0;i<nums.length;i++) {
            int last = nums.length-i-1;
            int maxIndex = getMaxIndex (nums, last);
            swap (nums, maxIndex, last);
        }
    }

    static int getMaxIndex (int[] nums,int last) {
        int max = 0;
        for (int i=0;i<=last;i++)
            if (nums[max] < nums[i]) max = i;
        return max;
    }

    static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
