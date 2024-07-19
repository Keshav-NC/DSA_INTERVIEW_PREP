package com.keshav.SDE.LeetDaily;

import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LuckyNumber {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }

    static List<Integer> luckyNumbers (int[][] matrix) {
        HashSet<Integer> minRows = new HashSet<>();
        HashSet<Integer> maxCols = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;


        // find min in each row
        for (int i = 0; i < rows; i++) {
            int min = matrix[i][0];
            for (int j = 0; j < cols; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            // store min in set
            minRows.add(min);
        }

        // find max in each col
        for (int i = 0; i < cols; i++) { // col
            int max = matrix[0][i];
            for (int j = 0; j < rows; j++) { // rows
                max = Math.max(max, matrix[j][i]);
            }
            // store max in set
            maxCols.add(max);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (minRows.contains(matrix[i][j]) && maxCols.contains(matrix[i][j])) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}
