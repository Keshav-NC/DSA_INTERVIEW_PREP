package com.keshav.SDE.LeetDaily;

import java.util.HashMap;

public class PaintRowOrCol {
    public static void main(String[] args) {
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};
        System.out.println(firstCompleteIndex(arr, mat));
    }
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }
        int index = 0;
        for (; index < arr.length; ++index) {
            int a = arr[index];
            int i = map.get(a)[0];
            int j = map.get(a)[1];
            boolean isFilled = true;
            mat[i][j] = -a; // mark
            // check row and col
            for (int col = 0; col < n; ++col) {
                if (mat[i][col] > 0) {
                    isFilled = false;
                    break;
                }
            }
            if (isFilled) break;
            isFilled = true;
            for (int row = 0; row < m; ++row) {
                if (mat[row][j] > 0) {
                    isFilled = false;
                    break;
                }
            }
            if (isFilled) break;
        }
        return index;
    }
}
