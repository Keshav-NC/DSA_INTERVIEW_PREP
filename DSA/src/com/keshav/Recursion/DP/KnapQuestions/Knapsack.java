package com.keshav.Recursion.DP.KnapQuestions;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int W = 7;
        int n = weight.length;
        // Recursive code
//        System.out.println(maxProfitRec(weight, value, W, n));
        // Recursive Code + dp
        int[][] dp = new int[n+1][W+1];
        // fill with -1=
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j] = -1;
            }
        }
//        System.out.println(maxProfitDP(weight, value, W, n, dp));
        // Tabulation

        System.out.println(maxProfitTabulation(weight, value, W, n));
    }

    // Recursive code
    private static int maxProfitRec (int[] weight, int[] value, int W, int n) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        // choice diagram
        /*
         *  1) take or not take --> weight[n-1] <= W
         *  2) not take --> weight[n-1] > W
         */

        if (weight[n-1] <= W) {
            //                      take                                                                                // not take
            return (int)(Math.max(value[n-1] + maxProfitRec(weight, value, W - weight[n-1], n-1), maxProfitRec(weight, value, W, n-1)));
        } else {
            // not take
            return maxProfitRec(weight, value, W, n-1);
        }
    }


    // Dp --> Recursion + memoization(storage) --> Top Down approach
    private static int maxProfitDP (int[] weight, int[] value, int W, int n, int[][] dp) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        // memoization
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // choice diagram
        /*
         *  1) take or not take --> weight[n-1] <= W
         *  2) not take --> weight[n-1] > W
         */

        if (weight[n-1] <= W) {
            //                      take                                                                                // not take
            return /*store */dp[n][W] = Math.max(value[n-1] + maxProfitDP(weight, value, W - weight[n-1], n-1, dp), maxProfitDP(weight, value, W, n-1, dp));
        } else {
            // not take
            return /*store */dp[n][W] = maxProfitDP(weight, value, W, n-1, dp);
        }
    }

    // Tabulation --> Bottom up approach
    private static int maxProfitTabulation (int[] weight, int[] value, int W, int n) {
        int[][] t = new int[n+1][W+1];
        // initialisation == base case in recursive code
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0; // base case
                }
            }
        }

        // choice diagram
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if (weight[i-1] <= j) {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // at last ans will be at last row and col
        return t[n][W];
    }
}
