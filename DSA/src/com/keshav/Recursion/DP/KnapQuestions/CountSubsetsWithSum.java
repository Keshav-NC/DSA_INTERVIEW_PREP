package com.keshav.Recursion.DP.KnapQuestions;

import java.util.Arrays;

public class CountSubsetsWithSum {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 5, 6, 8, 10};
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        /*
         *  {2, 8}
         *  {2, 3, 5}
         *  {10}
         *  return count = 3
         */
//        int sum = 10;
        int sum = 31;
        System.out.println(countSubsets (arr, sum));
    }

    private static int countSubsets(int[] arr, int sum) {
        return subsetSumCount(arr, sum, arr.length);
    }

    private static int subsetSumCount (int[] arr, int sum, int n) {
        int[][] t = new int[n+1][sum+1];
        /*
         *  1) We are initialising first column to 1, assuming there is only 1 way to make subset sum equal to 0,
         *  i.e. null subset, BUT this fails if we have 0's as elements of array.
         *  If we have a single 0 present in the array, then the subsets will be '{}, {0}' whose sum will be 0.
         *  Hence, there can be more than 1 way to make sum==0.
         *  FIX: Don't initialise the first col to be 1.
         *  Everything will be initialised to 0 except the first cell in the table
         *  i.e. dp[0][0]=1. AND j will start from 0 instead of 1.
         */
        t[0][0] = 1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
