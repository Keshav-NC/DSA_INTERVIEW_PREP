package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.List;

public class CheckIfNumbersAscInString {
    public static void main(String[] args) {
        String s = "27 tell 28 29 30 dare beat visit 31 sell 32 white";
        System.out.println(areNumbersAscending(s));
    }

    private static boolean areNumbersAscending(String s) {
        int n = s.length();
        int prev = 0;
        for (int i = 0; i < n; i++) {
            char first = s.charAt(i);
            char second = (i < n - 1) ? s.charAt(i + 1) : ' ';
            if (Character.isDigit(first)) {
                int curr = first - '0';
                if (Character.isDigit((second))) {
                    curr = curr * 10;
                    curr += second - '0';
                    ++i; // skip second char
                }
                System.out.println(curr);
                if (curr <= prev) return false;
                prev = curr;
            }
        }
        return true;
    }
}
