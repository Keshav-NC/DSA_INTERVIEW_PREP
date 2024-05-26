package com.ArraysQuestions.LinearSearching;

import java.util.Arrays;

public class LS2DArray {
    public static void main(String[] args) {
        int[][] arr = {
//                {1, 39, 60},
//                {3, 9, 66},
//                {-100, 78, 77},
        };
        int target = 39;
        int[] ans = ls2DArray(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] ls2DArray(int[][] arr, int target) {
        if (arr.length == 0) return new int[] {-1};

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                int element = arr[row][col];
                if(element == target) return new int[]{row, col};
            }
        }
        return new int[] {-1, -1};
    }


}
