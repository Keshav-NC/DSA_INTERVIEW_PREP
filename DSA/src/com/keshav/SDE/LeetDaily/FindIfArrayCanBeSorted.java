package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class FindIfArrayCanBeSorted {
    public static void main(String[] args) {
        int[] nums = {20,6,7,10,20,6,20};
        System.out.println(canSortArray(nums));
    }

    private static boolean canSortArray(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            int bit = Integer.bitCount(num);
            res[i++] = bit;
        }
        System.out.println(Arrays.toString(res));
        return true;
    }
}
