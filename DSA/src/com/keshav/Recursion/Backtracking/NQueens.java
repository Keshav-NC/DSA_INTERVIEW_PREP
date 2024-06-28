package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board ,0));

    }

    static int queens (boolean[][] board, int row) {
        // all the queens have been place --> found all the possible path
        // return 1 --> found 1 possible path
        if (row == board.length) {
            display (board);
            System.out.println();
            return 1;
        }

        // local to this call
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if (isSafe (board, row, col)) {
                board[row][col] = true;
                count += queens (board, row + 1);
                board[row][col] = false; // BT
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            // if true means already queen is present here, then it is not safe to place queen here
            // increment until we find safe place to place queen
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min (row, col);
        for (int i = 1; i <= maxLeft; i++) {
            // if true, then it is not safe to place queen here
            // both row and col is subtracting by i
            if (board[row-i][col-i]) {
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min (row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            // if true, then it is not safe to place queen here
            // both row and col is subtracting by i
            if (board[row-i][col+i]) {
                return false;
            }
        }

        // if none of these checks return false, then it is safe to place queen
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
