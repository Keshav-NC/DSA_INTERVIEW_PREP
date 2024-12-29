package com.keshav.SDE.LeetDaily;

import java.util.HashSet;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,2,3,10,2147483647,9};
        System.out.println(findMissing(nums));
    }

    private static int findMissing(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            seen.add(num);
            max = Math.max(num, max);
        }
        for (int i = 1; i < 2147483647; ++i) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
