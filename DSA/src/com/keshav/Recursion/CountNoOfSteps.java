package com.keshav.Recursion;

public class CountNoOfSteps {
    public static void main(String[] args) {
        System.out.println(getSteps(14));
    }

    static int helper (int num, int count) {

        if (num == 0) {
            return count;
        }

        if (num % 2 == 0) {
            return helper(num / 2, ++count);
        }
        return helper(num - 1, ++count);
    }

    static int getSteps (int num) {
        return helper(num, 0);
    }


}
