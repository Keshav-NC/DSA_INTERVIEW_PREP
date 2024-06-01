package com.keshav.SDE;

// https://leetcode.com/problems/harshad-number/
public class HarshadNumber {
    public static void main(String[] args) {
        System.out.println(harshad(18));
    }

    static int harshad(int x) {
        int sum = 0;
        int copy = x;
        while (copy != 0) {
            sum += copy % 10;
            copy /= 10;
        }
        if (x % sum == 0) {
            return sum;
        }
        return -1;
    }
}
