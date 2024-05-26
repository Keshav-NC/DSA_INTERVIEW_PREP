package com.ArraysQuestions.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(sumOfDigits(num));
    }

    static int sumOfDigits (int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10) + sumOfDigits(num/10);
    }
}
