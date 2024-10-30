package com.keshav.Recursion.DP.KnapQuestions.Unbounded;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5 ,6, 7 ,8}; // this may not be given in question --> then consider 1 to N (1-indexed)
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
        int N = 8; // rod length
//        System.out.println(rodCut(length, price, N));
        System.out.println(rodCutWithoutLength(price, N));
    }

    private static int rodCut(int[] length, int[] price, int w) {
        int n = length.length;
        //                length price
        int[][] dp = new int[n + 1][w + 1];

        // initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[n][w];
    }
    private static int rodCutWithoutLength (int[] price, int n) {
        // n = rod length (1-indexed)
        int w = price.length;
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if (i <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[n][w];
    }
}
