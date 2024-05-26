package com.ArraysQuestions.Strings;

public class Patterns {
    public static void main(String[] args) {
        int n = 4;
//        pattern1(n);
//        pattern2(n);
//        pattern3(n);
//        pattern4(n);
//        pattern5(5);
        pattern28(5);
    }

    // HOW TO APPROACH PATTERNS QUESTIONS
    // 1) no of lines = no of rows = no of times the outer loop will run.
    // 2) Identify for every row num
    //      - how many cols are there.
    //      - types of elements in col (1, 2, 3, ...).
    // 3) What do you need to print
    // NOTE: Try to find formulae relating rows and cols

    // Questions --> https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/09-patterns.md

    static void pattern1 (int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            //for each row, run col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add newLine
            System.out.println();
        }
    }

    static void pattern3 (int n) {
        for (int row = 1; row <= n ; row++) {
            for (int col = n; col >= row ; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4 (int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static void pattern5 (int n) {
        for (int row = 1; row <= 2*n; row++) {
            //Method 1
//            if (row > n) {
//                for (int col = n-1; col >= row-n ; col--) {
//                    System.out.print("* ");
//                }
//            } else {
//                for (int col = 1; col <= row ; col++) {
//                    System.out.print("* ");
//                }
//            }

            //Method 2
            int totalNoOfCols = row > n ? 2*n-row : row;
            for (int col = 1; col <= totalNoOfCols ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern28 (int n) {
        for (int row = 1; row <= 2*n; row++) {
            int totalNoOfCols = row > n ? 2*n-row : row;
            int noOfSpaces = n - totalNoOfCols;
            for (int s = 0; s < noOfSpaces ; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totalNoOfCols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
