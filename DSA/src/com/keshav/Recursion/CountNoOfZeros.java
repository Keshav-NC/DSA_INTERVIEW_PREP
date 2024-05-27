package com.keshav.Recursion;

public class CountNoOfZeros {
    public static void main(String[] args) {
        System.out.println(getCount(102030440));
    }

    // Special pattern, how to pass a value to the above calls --> just debug and see how the recursion tree is working
    static int helper (int num, int count) {

        if (num == 0) {
            return count;
        }

        if (num % 10 == 0) {
            return helper(num / 10, ++count);
        }

        return helper(num / 10, count);
    }

    static int getCount (int num) {
        return helper(num, 0);
    }
}
