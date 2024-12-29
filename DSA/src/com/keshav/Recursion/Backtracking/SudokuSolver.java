package com.keshav.Recursion.Backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(sudokuSolver(0, 0, board));
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean sudokuSolver(int row, int col, char[][] board) {
        // Base case: If we reach the 9th row, the board is solved
        if (row == 9) {
            return true;
        }
        // If we reach the end of a col, move to the next row
        if (col == 9) {
            return sudokuSolver(row + 1, 0, board);
        }
        // If the cell is already filled, move to the next column
        if (board[row][col] != '.') {
            return sudokuSolver(row, col + 1, board);
        }
            for (int value = 1; value < 10; value++) {
                char digit = (char)(value + '0');
                if (isValid(row, col, digit, board)) {
                    board[row][col] = digit; // make changes
                    if (sudokuSolver(row, col + 1, board)) {
                        return true; // If solving further leads to a solution, return true
                    }
                }
            }
        board[row][col] = '.'; // revert changes
        // If no valid number fits, return false to backtrack
        return false;
    }

    private static boolean isValid(int row, int col, char value, char[][] board) {
        // row
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == value) {
                return false;
            }
            if (board[c][col] == value) {
                return false;
            }
        }

        // sub grid
        // get the starts index of the sub grid
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == value) return false;
            }
        }
        return true;
    }
}
