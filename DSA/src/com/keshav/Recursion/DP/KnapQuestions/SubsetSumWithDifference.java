package com.keshav.Recursion.DP.KnapQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSumWithDifference {
    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 11};
        System.out.println(minimumDifference (arr));
    }

    private static int minimumDifference(int[] arr) {
        int range = Arrays.stream(arr).sum();
        subsetSum(arr, range, arr.length);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < valid.size()/2; i++) {
            min = Math.min(min, range - 2*valid.get(i));
        }
        return min;
    }
    // subset sum
    static ArrayList<Integer> valid;
    private static void subsetSum (int[] arr, int range, int n) {
        boolean[][] t = new boolean[n+1][range+1];
        int k = 0;
        while (k < n+1) {
            t[k][0] = true;
            ++k;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < range+1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // last row contains valid candidates
        valid = new ArrayList<>();
        for (int i = 0; i < t[0].length; ++i) {
            if (t[n][i]) {
                valid.add(i);
            }
        }
        System.out.println(valid);
    }
}
