package com.keshav.SDE.LeetDaily;

import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        String s = "df45t7yu";
        System.out.println(clearDigits(s));
    }

    private static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int top = -1;

        for (char ch : s.toCharArray()) {
            if (top != -1 && Character.isDigit(ch)) {
                sb.deleteCharAt(sb.length() - 1);
                ++top;
                continue;
            }
            sb.append(s.charAt(++top));
        }
        return sb.toString();
    }
}
