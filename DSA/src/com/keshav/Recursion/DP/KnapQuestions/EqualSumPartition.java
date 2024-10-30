package com.keshav.Recursion.DP.KnapQuestions;

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 5};
        System.out.println(equalSum (arr));
    }

    private static boolean equalSum(int[] arr) {
        /*
         *  Similarity ->
         *          - from given array, find equal sum,
         *          - sum == even --> just find subset using subsetSum() eg: sum = 22 --> 22/2 == 11 (11 + 11 = 22) --> find whether a subset possible or not using previous problem(subsetSum())
         *          - sum == odd --> not possible at all --> just return false
         *  Identification ->
         *          - subsetSum()
         */

        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) { // odd case
            // not possible to divide into equal parts
            return false;
        } else { // even case
            return subsetSum(arr, sum/2, arr.length);
        }
    }

    private static boolean subsetSum (int[] arr, int sum, int n) {
        // same subsetSum problem
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
                if (arr[i - 1] <= j) {
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
