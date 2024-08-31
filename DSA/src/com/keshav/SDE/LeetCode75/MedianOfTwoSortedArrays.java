package com.keshav.SDE.LeetCode75;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(Arrays.toString(medianOfTwoArrays(nums1, nums2)));
    }

    private static int[] medianOfTwoArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < m) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        return nums;
    }
}
