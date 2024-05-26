package com.ArraysQuestions.Maths.BitwiseOperator;

public class NoOfDigits {
    public static void main(String[] args) {
        int num = 128;
        int base = 2;
        // Time Complexity log(n)
        // to convert anything into base, divide it by same log of that base
        int ans = (int) (Math.log(num) / Math.log(base)) + 1;
        System.out.println(ans);
    }
}
