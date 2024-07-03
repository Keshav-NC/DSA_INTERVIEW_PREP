package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class MinDiffirence {
    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};
        System.out.println(minDiff(nums));
    }
    static int minDiff (int[] nums) {
        int n = nums.length;
        // [1, 3, 4, 2] --> sort --> [1, 2, 3, 4] --> replace last 3 num with 1 --> [1, 1, 1, 1] --> 1 - 1 = 0
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        // case 1 --> all largest 3
        ans = Math.min(ans, nums[n-4] - nums[0]);

        // case 2 --> 2 large, 1 small
        ans = Math.min(ans, nums[n-3] - nums[1]);

        // case 3 --> 1 large, 2 small
        ans = Math.min(ans, nums[n-2] - nums[2]);

        // case 4 --> all smallest 3
        ans = Math.min(ans, nums[n-1] - nums[3]);

        return ans;
    }

}
