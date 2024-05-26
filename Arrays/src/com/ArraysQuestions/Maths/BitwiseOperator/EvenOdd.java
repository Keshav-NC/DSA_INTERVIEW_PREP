package com.ArraysQuestions.Maths.BitwiseOperator;

public class EvenOdd {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(isEvenOdd(n) ? "Even" : "Odd");
    }

    static boolean isEvenOdd(int n) {
        if ((n&1) == 1) {
            return false;
        }
        return true;
    }
}
