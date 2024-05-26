package com.ArraysQuestions.Maths.BitwiseOperator;

public class NewtonRaphsonSQRT {
    public static void main(String[] args) {
        int num = 8;
        System.out.printf("%.2f", sqrt(num));

    }

    private static double sqrt(double num) {
        // Formula --> 0.5 * (x + num / x)
        // error = |root-x|
        double x = num;
        double root = 0.0;
        while (true) {
            root = 0.5 * (x + num / x);
            if (Math.abs(root - x) < 0.1) {
                break;
            }
            x = root;
        }
        return root;
    }
}
