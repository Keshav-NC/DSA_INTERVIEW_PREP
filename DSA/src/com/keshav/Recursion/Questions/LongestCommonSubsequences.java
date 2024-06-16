package com.keshav.Recursion.Questions;

public class LongestCommonSubsequences {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(longCommonSub(str1, str2, n-1, m-1, dp));
    }

    private static int longCommonSub(String str1, String str2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        // check if the state has been visited previously, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            // memoization
            return dp[i][j] = 1 + longCommonSub(str1, str2, i-1, j-1, dp);
        }
        // memoization
        return dp[i][j] = Math.max(longCommonSub(str1, str2, i, j-1, dp), longCommonSub(str1, str2, i-1, j, dp));
    }
}
