package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class MoveAllBalls {
    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    private static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '0') continue;
                res[i] += Math.abs(i - j);

            }
        }
        return res;
    }
}
