package com.ArraysQuestions.Maths.BitwiseOperator;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 0;
        boolean ans = (n & (n-1)) == 0;
        System.out.println( n != 0 ? ans : false);
    }
}
