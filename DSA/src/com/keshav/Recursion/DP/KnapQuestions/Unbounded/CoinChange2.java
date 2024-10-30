package com.keshav.Recursion.DP.KnapQuestions.Unbounded;

import java.util.Arrays;

// Min number of coins
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 3;
        System.out.println(coinCount(coins, amount));
    }

    private static int coinCount(int[] coins, int amount) {
        return subsetSumUnb(coins, amount, coins.length);
    }
    private static int subsetSumUnb(int[] coins, int amount, int n) {
        int[][] dp = new int[n+1][amount+1];

        for (int i = 1; i < amount+1; i++) {
            if (i % coins[0] == 0) {
                dp[1][i] = i/coins[0];
            } else {
                dp[1][i] = Integer.MAX_VALUE-1;
            }
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
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
