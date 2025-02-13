package com.keshav.Recursion.Backtracking;

import java.util.Arrays;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
    static int count;
    private static int combinationSum4(int[] nums, int target) {
        count = 0;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        findCombinations4(0, 0, target, nums, nums.length, dp);
        return count;
    }

    private static void findCombinations4(int start, int sum, int target, int[] nums, int n, int[] dp) {
        if (start == n ) {
            dp[start] = 0;
            return;
        }
        if (dp[start] != -1) {
            return;
        }
        if (sum > target) {
            dp[start] = 0;
            return;
        }
        if (sum == target) {
            ++count;
            dp[start] = count;
            return;
        }
        for (int i = 0; i < n; ++i) {
            findCombinations4(i, sum + nums[i], target, nums, n, dp);
        }
    }
}
