package com.keshav.Maths.BitwiseOperator;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 34;
        for (int i = 2; i < num; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }



    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while (c <= num/c) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
