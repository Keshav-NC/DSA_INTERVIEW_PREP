package com.keshav.Recursion;

public class RevTriangle {
    public static void main(String[] args) {
        int n = 4;
        triangle(n);
    }

    static void triangle(int n) {
        // n --> row
        // 0 --> col
        helper (n, 0);
    }

    static void helper (int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            System.out.print("* ");
            helper(row, ++col);
            System.out.print("* ");
        } else {
            System.out.println();
            helper(--row, 0);
            System.out.println();
        }
    }
}
