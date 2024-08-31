package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 5, 5};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return ans;
    }
}
