package com.keshav.Recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(0));
    }

    static boolean powerOfTwo (int n) {
        return helper (n , 0);
    }

    private static boolean helper(int n, int i) {
        if (i > n) {
            return false;
        }
        if (n == 0 || n == Math.pow (2, i)) {
            return true;
        }
        return helper(n, ++i);
    }
}
