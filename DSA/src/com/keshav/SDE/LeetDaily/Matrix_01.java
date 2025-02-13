package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class Matrix_01 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(onesMinusZeros(grid)));
    }
    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        // number of ones in row[i]
        for (int i = 0; i < m; ++i) {
            int ones = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++ones;
                }
            }
            onesRow[i] = ones;
        }
        // number of ones in col[i]
        for (int i = 0; i < n; ++i) {
            int ones = 0;
            for (int j = 0; j < m; ++j) {
                if (grid[j][i] == 1) {
                    ++ones;
                }
            }
            onesCol[i] = ones;
        }
        System.out.println(Arrays.toString(onesRow));
        System.out.println(Arrays.toString(onesCol));
        int[][] diff = new int[m][n];
        // diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
        for (int i = 0; i < m; i++) {
            int zerosRow = n - onesRow[i];
            for (int j = 0; j < n; j++) {
                int zerosCol = m - onesCol[j];
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow - zerosCol;
            }
        }
        return diff;
    }
}
