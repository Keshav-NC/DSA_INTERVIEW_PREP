package com.keshav.SlidingWindow;

import javax.imageio.ImageTranscoder;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(maximum (nums, k));
    }

    private static double maximum (int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum/2;
        for (int i = 1; i < n-k+1; i++) {
            int remove = nums[i-1];
            int add = nums[i+k-1];

            sum -= remove;
            sum += add;

            maxAvg = Math.max(maxAvg, (double) sum / 2);
        }
        return maxAvg;
    }
}
