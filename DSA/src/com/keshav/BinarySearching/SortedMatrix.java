package com.keshav.BinarySearching;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };
        int target = 5;
        System.out.println(Arrays.toString(search(matrix, target)));
    }

    // search in the row provided between the cols provided
    static int[] bs (int[][] matrix, int target, int row, int cStart, int cEnd) {
        int mid = cStart + (cEnd - cStart) / 2;
        if (target == matrix[row][mid]) {
            return new int[] {row, mid};
        }
        if (target < matrix[row][mid]) {
            cEnd = mid - 1;
        } else {
            cStart = mid + 1;
        }
        return new int[] {-1, -1};
    }

    static int[] search (int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1) {
            return bs(matrix, target, 0, 0, cols-1);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows
            int rMid = rStart + (rEnd - rStart) / 2;
            if (target == matrix[rMid][cMid]) {
                return new int[] {rMid, cMid};
            }
            if (target < matrix[rMid][cMid]) {
                rEnd = rMid;
            } else {
                rStart = rMid;
            }
        }
        // now we have 2 rows
        // check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[] {rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[] {rStart + 1, cMid};
        }

        // check in 1st half
        if (target <= matrix[rStart][cMid-1]) {
            return bs(matrix, target, rStart, 0, cMid-1);
        }
        // check in 2nd half
        if (target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]) {
            return bs(matrix, target, rStart, cMid+1, cols-1);
        }
        // check in 3rd half
        if (target <= matrix[rStart+1][cMid-1]) {
            return bs(matrix, target, rStart+1, 0, cMid-1);
        }
        // check in 4th half
        else {
            return bs(matrix, target, rStart+1, cMid+1, cols-1);
        }
    }
}
