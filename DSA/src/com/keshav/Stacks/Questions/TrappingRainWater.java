package com.keshav.Stacks.Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {2,3,3,2,3,1};
        System.out.println(waterArea(heights));
    }
    static int n;
    private static int[] findMaxLeft(int[] heights) {
        int[] left = new int[n];
        left[n-1] = heights[n-1];
        for (int i = n - 2; i >= 0; --i) {
            left[i] = Math.max(left[i + 1], heights[i]);
        }
        return left;
    }

    private static int[] findMaxRight(int[] heights) {
        int[] right = new int[n];
        right[0] = heights[0];
        for (int i = 0; i < n; ++i) {
            right[i] = Math.max(right[i], heights[i]);
        }
        return right;
    }

    private static int waterArea(int[] heights) {
        n = heights.length;
        int[] maxLeft = findMaxLeft(heights);
        int[] maxRight = findMaxRight(heights);
        int area = 0;

        for (int i = 0; i < n; i++) {
            area += Math.min(maxLeft[i], maxRight[i]) - heights[i];
        }
        return area;
    }
}
