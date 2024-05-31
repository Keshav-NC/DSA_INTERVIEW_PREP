package com.keshav.SDE;

import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZerosOptimised(matrix);
        for (int[] ele : matrix) {
            System.out.println(Arrays.toString(ele));
        }
    }

    // optimised approach --> TC: O(n^2) SC: O(1)
    // in this approach we are using row[0][0] as col[0] and col[0][0] as row[0] --> similar to better approach
    static void setZerosOptimised (int[][] matrix) {
        int m = matrix.length;
        int n= matrix[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = -1;
                    matrix[0][col] = -1;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }


    // better approach --> TC: O(n^2) ans SC: O(m + n)
    static void setZerosBetter (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // create new 1d array for keep tracking the no of 0's in the row
        boolean[] row = new boolean[m];

        // create new 1d array for keep tracking the no of 0's in the col
        boolean[] col = new boolean[n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // check the value 0, if found mark true in that respective indexes
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] = true;
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (row[r] || col[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
//        System.out.println(Arrays.toString(row));
//        System.out.println(Arrays.toString(col));
    }


    // brute force --> TC: O(n^3) SC: O(1)
    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // traverse entire matrix
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // check for the value 0
                if (matrix[row][col] == 0) {
                    // mark the rows and cols by -1 expect if values are 0 then skip it and mark -1 rest
                    markRow (matrix, row, m);
                    markCol (matrix, col, m);
                }
            }
        }
        // after inserting -1, again traverse entire matrix, then replace -1 by 0
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private static void markCol(int[][] matrix, int col, int m) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }

    private static void markRow(int[][] matrix, int row, int m) {
        for (int i = 0; i < m; i++) {
            if(matrix[row][i] != 0) {
                matrix[row][i] = -1;
            }
        }
    }

}
