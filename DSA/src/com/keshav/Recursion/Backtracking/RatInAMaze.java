package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;

class Direction {
    char dName;
    int dx;
    int dy;
    public Direction(char dName, int dx, int dy) {
        this.dName = dName;
        this.dx = dx;
        this.dy = dy;
    }
}
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
            };
        ArrayList<String> paths = new ArrayList<>();
        Direction up = new Direction('U', -1, 0);
        Direction right = new Direction('R', 0, 1);
        Direction down = new Direction('D', 1, 0);
        Direction left = new Direction('L', 0, -1);

        ArrayList<Direction> choices = new ArrayList<>();
        choices.add(up);
        choices.add(right);
        choices.add(down);
        choices.add(left);
        allPaths(mat, new StringBuilder(), 0, 0, paths, choices);
        System.out.println(paths);
    }

    private static void allPaths(int[][] mat, StringBuilder path, int x, int y, ArrayList<String> paths, ArrayList<Direction> choices) {
        if (isSolved(mat, x, y)) {
            paths.add(path.toString());
            return;
        }
        for (Direction choice : choices) {
            int newX = x + choice.dx;
            int newY = y + choice.dy;
            if (isValid(newX, newY, mat)) {
                mat[x][y] = 0; // mark the current cell as visited in mat
                path.append(choice.dName);
                allPaths(mat, path, newX, newY, paths, choices);
                mat[x][y] = 1; // restore the original value in mat
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private static boolean isValid(int x, int y, int[][] mat) {
        return (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && mat[x][y] == 1);
    }

    private static boolean isSolved(int[][] mat, int x, int y) {
        return (x == mat.length - 1 && y == mat[0].length - 1);
    }
}
