package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;

public class MazeDR {
    public static void main(String[] args) {
//        System.out.println(countPaths(2, 2));
//        path("", 2, 2);
        System.out.println(pathAL("", 2, 2));
    }

    static int countPaths (int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }

        int left = countPaths(row-1, col);
        int right = countPaths(row, col-1);

        return left + right;
    }

    static void path (String p, int row, int col) {
        if (row == 0 && col == 0) {
            System.out.print(p + " ");
            return;
        }

        if (row > 0) {
            path(p + "D", row-1, col);
        }
        if (col > 0) {
            path(p + "R", row, col-1);
        }
    }

    static ArrayList<String> pathAL (String p, int row, int col) {
        if (row == 0 && col == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if (row > 0) {
            list.addAll(pathAL(p + "D", row-1, col));
        }

        if (col > 0) {
            list.addAll(pathAL(p + "R", row, col-1));
        }
        return list;
    }
}
