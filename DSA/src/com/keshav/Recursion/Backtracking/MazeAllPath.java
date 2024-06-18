package com.keshav.Recursion.Backtracking;

public class MazeAllPath {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };
        allPath("", board, 0, 0);
    }


    // Actual backtracking explained here
    /*
        Backtracking : we are making changes while we are in below recursion call, so when we go
        outside these recursion call, changes that were made via those recursion calls should also not
        be available
        VVVIMP --> 1) Make the change
                   2) Revert the change, after the work has been done
     */
    static void allPath (String p, boolean[][] maze, int row, int col) {
        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.print(p + " ");
            return;
        }
        // if you land on river(obstacle), just stop the recursion here or return from here
        if (!maze[row][col]) {
            return;
        }
        /*
            Making false == I have that cell in my current path
            so when that path is over, eg: consider we are in another recursion
            call, these cells should not be false --> coz this may be another possible path
         */
        // iam considering this block is my path
        maze[row][col] = false;

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

        // Note Imp :: while we are moving back, we restore the maze as it was --> this is "BACKTRACKING"
        /*
            coz there may be another possible path, for that purpose we are restoring the maze as it was before
            so that we can find all possible paths
         */
        // this line is where the function will over1
        // so before the function gets removed, also remove the changes that were made by that function
        maze[row][col] = true;
    }
}
