package com.keshav.Maths.BitwiseOperator;

import java.util.ArrayList;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 10;
//        for (int i = 2; i < num; i++) {
//            System.out.println(i + " " + isPrime(i));
//        }
        ArrayList<Integer> count = new ArrayList<>();
        for (int i=2;i<num;i++) {
            if (isPrimeRet(i)) {
                count.add(i);
            }
        }
        System.out.println(count);
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

    static  boolean isPrimeRet (int num) {
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
