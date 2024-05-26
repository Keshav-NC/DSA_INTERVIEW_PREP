package com.ArraysQuestions.Maths.BitwiseOperator;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int num = 8;
        int precise = 3;
        System.out.printf("%.3f", sqrtBSPrecise(num, precise));
    }

    // TC --> O (log(n))

    static double sqrtBSPrecise (int num, int p) {
        int start = 1;
        int end = num;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == num/mid) {
                return mid;
            }
            if (mid*mid > num) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= num) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }


    private static int sqrtBS(int num) {
        int start = 1;

        while (start <= num) {
            int mid = start + (num - start) / 2;
            if (mid <= num/mid) {
                start = mid+1;
            } else {
                num = mid-1;
            }
        }
        return start;
    }
}
