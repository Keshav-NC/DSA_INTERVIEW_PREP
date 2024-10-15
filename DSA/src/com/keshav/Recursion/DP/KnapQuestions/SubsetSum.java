package com.keshav.Recursion.DP.KnapQuestions;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 12;
        int n = arr.length;
//        System.out.println(findSubsetRec(arr, sum, n));
        System.out.println(findSubset(arr, sum, n));
    }

    private static boolean findSubset (int[] arr, int sum, int n) {
        /*
         *  1) Identification ->
         *          - choice -> take or not take
         *          - optimal -> in this case --> sum
         *  2) Similarity -> (Knapsack)
         *          - arr[] == wt[] (Knapsack)
         *          - sum == W(Knapsack)
         */
        // initialize
        boolean[][] t = new boolean[n+1][sum+1];
        int k = 0;
        while (k < n+1) {
            t[k][0] = true;
            ++k;
        }
        // i --> n
        // j --> sum
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for (boolean[] row : t) {
            System.out.println(Arrays.toString(row));
        }
        return t[n][sum];
    }
}
