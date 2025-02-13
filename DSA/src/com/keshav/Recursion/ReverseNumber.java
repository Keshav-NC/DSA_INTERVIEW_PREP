package com.keshav.Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverseNumber3(num));
    }

    // Method 1
    // This is not pure recursion
    static int ans = 0;
    static int reverseNumber1 (int num) {

        if (num == 0) {
            return ans;
        }
        ans = ans * 10 + num % 10;
        return reverseNumber1(num / 10);
    }

    // Method 2
    static int helper(int num, int digits) {
        if (num % 10 == num) {
            return num;
        }
        return num % 10 * (int)(Math.pow(10, digits - 1)) + helper(num / 10, digits - 1);
    }

    static int reverseNumber2 (int num) {
        // sometimes you may need additional variables in the argument in that case, make another function
        int digits = (int)(Math.log10(num) + 1);
        return helper(num, digits);
    }

    static int reverseNumber3(int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }


}
