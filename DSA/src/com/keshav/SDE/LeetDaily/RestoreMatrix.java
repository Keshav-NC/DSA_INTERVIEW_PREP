package com.keshav.SDE.LeetDaily;

//https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/submissions/1327275164/?envType=daily-question&envId=2024-07-20

import java.util.Arrays;

public class RestoreMatrix {
    public static void main(String[] args) {
        int[] rowSum = {5,7,10};
        int[] colSum = {8,6,8};
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum, colSum)));
    }

    private static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] resMatrix = new int[rows][cols];
        int r = 0;
        int c = 0;

        while (r < rows && c < cols) {
            int minVal = Math.min (rowSum[r], colSum[c]);
            resMatrix[r][c] = minVal;
            rowSum[r] -= minVal;
            colSum[c] -= minVal;

            if (rowSum[r] == 0) {
                r++;
            } else {
                c++;
            }
        }
        return resMatrix;
    }
}
