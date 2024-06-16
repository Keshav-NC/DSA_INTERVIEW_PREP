package com.keshav.Recursion.Backtracking;

public class MazeAllPath {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, false, true},
                {true, true, true},
                {true, true, true},
        };
        allPath("", board, 0, 0);
    }

    static void allPath (String p, boolean[][] maze, int row, int col) {
        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        // move down
        if (row < maze.length-1) {
            allPath(p + "D", maze, row+1, col);
        }
        // move up
        if (row > 0) {
            allPath(p + "U", maze, row-1, col);
        }
        // move right
        if (col < maze[0].length-1) {
            allPath(p + "R", maze, row, col+1);
        }
        // move left
        if (col > 0) {
            allPath(p + "L", maze, row, col-1);
        }
    }
}
