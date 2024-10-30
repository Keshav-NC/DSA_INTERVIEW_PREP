package com.keshav.Recursion.DP.KnapQuestions.Unbounded;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int W = 7;
        System.out.println(unboundedKnapsack (weight, value, W));
    }

    private static int unboundedKnapsack(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[][] dp = new int[n+1][w+1];
        // initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // base case
                }
            }
        }

        // same as knapsack problem -->
        /*
         * in knapsack --> two choices
         *  1) take or not take --> processed
         *  2) not take --> processed
         *
         * in unbounded knapsack --> two choices
         *  1) take --> unprocessed --> we can use again and again --> multiple occurrences of same item
         *  2) not take --> processed --> we don't need it
         *
         *  only change in code --> dp[i][j] = Math.max(value[i-1] + **dp[i-1]**[j - weight[i-1]], dp[i-1][j]) to dp[i][j] = Math.max(value[i-1] + **dp[i]**[j - weight[i-1]], dp[i-1][j])
         */
        // choice diagram
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i-1] + dp[i][j - weight[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
