package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;

public class NDigitsIncreasing {
    public static void main(String[] args) {
        int n = 2;
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 10; i++) {
                ans.add(i);
            }
        } else {
            nDigits(n, 1, new StringBuilder(), ans);
        }
        System.out.println(ans);
    }

    private static void nDigits(int n, int start, StringBuilder num, ArrayList<Integer> ans) {
        if (n == 0) {
            ans.add(Integer.valueOf(num.toString()));
            return;
        }
        for (int i = start; i < 10; i++) {
            num.append(i);
            nDigits(n - 1, i + 1, num, ans);
            num.deleteCharAt(num.length() - 1);
        }
    }
}
