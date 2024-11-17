package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        reverse(s, 0);
    }

    private static void reverse(char[] s, int i) {
        if (i > s.length - 1) {
            return;
        }
        reverse(s, i+1);
        s[i] = s[s.length - i - 1];
    }
}
