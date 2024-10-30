package com.keshav.Recursion.DP.KnapQuestions.Unbounded;

import java.util.Arrays;

// Max Number of ways
public class CoinChange1 {
    public static void main(String[] args) {
        int[] coins = {2,5,3,6};
        int amount = 10;
        System.out.println(coinChange (coins, amount));

    }

    private static int coinChange(int[] coins, int amount) {
        return subsetSum(coins, amount, coins.length);
    }
    // subset sum --> unbounded
    private static int subsetSum (int[] coins, int amount, int n) {
        int[][] dp = new int[n+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[n][amount];
    }
}
