package com.keshav.Recursion.Backtracking;

import java.util.Arrays;

public class MazeAllPathInMatrix {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        allPathMat("", board, 0, 0,1 ,new int[board.length][board[0].length]);
//        System.out.println(Arrays.toString(board));
    }

    private static void allPathMat(String p, boolean[][] maze, int row, int col, int step ,int[][] paths) {
        if (row == maze.length-1 && col == maze[0].length-1) {
            paths[row][col] = step;
            for (int[] path : paths) {
                System.out.println(Arrays.toString(path));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;
        paths[row][col] = step;

        if (row < maze.length-1) {
            allPathMat(p + "D",maze, row+1, col, step+1, paths);
        }

        if (row > 0) {
            allPathMat(p + "U", maze, row-1 ,col, step+1, paths);
        }

        if (col < maze[0].length-1) {
            allPathMat(p + "R" ,maze, row, col+1, step+1, paths);
        }

        if (col > 0) {
            allPathMat(p + "L" ,maze, row, col-1, step+1, paths);
        }
        maze[row][col] = true;
        paths[row][col] = 0;
    }
}
