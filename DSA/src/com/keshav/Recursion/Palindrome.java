package com.keshav.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        int num = 121421;
        System.out.println(isPalindrome(num));
        System.out.println();
    }

    static int helper (int num, int digits) {
        if (num % 10 == num) {
            return num;
        }
        return num % 10 * (int)(Math.pow(10, digits - 1)) + helper(num / 10, digits - 1);
    }


    static int reverse (int num) {
        int digits = (int) (Math.log10(num) + 1);
        return helper(num, digits);
    }

    static boolean isPalindrome (int num) {
        return num == reverse(num);
    }


}
