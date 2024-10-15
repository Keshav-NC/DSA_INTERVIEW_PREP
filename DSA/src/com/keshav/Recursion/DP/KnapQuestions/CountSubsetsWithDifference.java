package com.keshav.Recursion.DP.KnapQuestions;

import java.util.Arrays;

public class CountSubsetsWithDifference {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int diff = 1;
        System.out.println(countSubsetDifference(arr, diff));
    }

    private static int countSubsetDifference(int[] arr, int diff) {
        int totalSum = Arrays.stream(arr).sum();
        /*
         *  2) We also need to take care of the edge case where it's not possible to partition the array.
         *  In the derived formula, target = (diff+totalSum) / 2,
         *  NOTICE that (diff+totalSum) must be even for target to be a whole number,
         *  else it's not possible to find a decimal target in subset sum.
FIX:     *  Check, if it's odd,  there is no way --> if((diff+totalSum)%2 != 0) return 0;
         */
        if ((diff + totalSum) % 2 != 0) { // odd --> not possible
            return 0;
        } else {
            int sum = (diff + totalSum) / 2;
            return subsetSumCount(arr, sum, arr.length);
        }
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
