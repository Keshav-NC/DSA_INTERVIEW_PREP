package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;

public class MazeDiagonal {
    public static void main(String[] args) {
//        path("", 2, 2);
        System.out.println(pathAl("", 2, 2));

    }

    static void path (String p, int row, int col) {
        if (row == 0 && col == 0) {
            System.out.print(p + " ");
            return;
        }
        // move down
        if (row > 0) {
            path(p + "V", row-1, col);
        }

        // move diagonal
        if (row > 0 && col > 0) {
            path(p + "D", row - 1, col - 1);
        }


        // move right
        if (col > 0) {
            path(p + "H", row,col-1);
        }
    }

    static ArrayList<String> pathAl (String p, int row, int col) {
        if (row ==0 && col == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }


        ArrayList<String> list = new ArrayList<>();
        if (row > 0) {
            list.addAll(pathAl(p + "V", row-1, col));
        }

        if (row > 0 && col > 0) {
            list.addAll(pathAl(p + "D", row-1, col-1));
        }

        if (col > 0) {
            list.addAll(pathAl(p + "H", row, col-1));
        }
        return list;
    }
}
