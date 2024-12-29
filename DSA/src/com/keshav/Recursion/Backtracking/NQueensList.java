package com.keshav.Recursion.Backtracking;

import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.List;

public class NQueensList {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nQueens(n));

    }

    private static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<String >> ansString = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        possiblePlaces(0 , board, ans, ansString, new ArrayList<>(), n);
        return ans;
    }

    private static void possiblePlaces(int col, boolean[][] board, List<List<Integer>> ans, List<List<String>> ansString, List<Integer> sub, int n) {
        if (col == n) {
            List<String> boardRepresentation = new ArrayList<>();
            for (boolean[] row : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean isQueen : row) {
                    if (isQueen) sb.append("Q");
                    else sb.append(".");
                }
                boardRepresentation.add(sb.toString());
            }
            ansString.add(new ArrayList<>(boardRepresentation));
            System.out.println(ansString);
            ans.add(new ArrayList<>(sub));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = true;
                sub.add(row + 1);
                possiblePlaces(col + 1, board, ans, ansString, sub, n);
                sub.remove(sub.size() - 1);
                board[row][col] = false;
            }
        }
    }


    private static boolean isSafe(int row, int col, boolean[][] board) {
        // left
        for (int i = 0; i < col; i++) {
            if (board[row][i]) { // queen present
                return false;
            }
        }
        // upper left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // lower left
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }
}
