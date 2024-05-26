package com.ArraysQuestions.BinarySearching;

import java.util.Arrays;

public class RowColBinarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30},
                {15, 25, 35},
                {20, 30, 40},
                {40, 45, 60},
        };
        int target = 40;
        System.out.println(Arrays.toString(search2D(matrix, target)));


    }

    static int[] search2D (int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length-1;
        //row should be greater than length because its going to be incremented,
        //col should not exceed 0 because its going to be decremented

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return new int[] {row, col};
            // if element < target, then increment the row
            else if (matrix[row][col] < target) row++;
            // if element > target , then decrement the col
            else col--;
        }
        return new int[] {-1, -1};
    }
}

