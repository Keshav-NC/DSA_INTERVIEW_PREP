package com.keshav.Recursion.Backtracking;

public class MazeObstacle {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };
//        pathObstacle("", maze, 0, 0);
        pathObsDiagonal("", maze, 0, 0);
    }

    static void pathObstacle (String p, boolean[][] maze, int row, int col) {
        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length-1) {
            pathObstacle(p + 'D', maze, row+1, col);
        }

        if (col < maze[0].length-1) {
            pathObstacle(p + 'R', maze, row, col+1);
        }
    }

    static void pathObsDiagonal (String p, boolean[][] maze, int row, int col) {
        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.print(p + " ");
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length-1) {
            pathObsDiagonal(p + "V", maze, row+1, col);
        }

        if (row < maze.length-1 && col < maze[0].length-1) {
            pathObsDiagonal(p + "d", maze, row+1, col+1);
        }

        if (col < maze[0].length-1) {
            pathObsDiagonal(p + "H" ,maze, row, col+1);
        }
    }
}
