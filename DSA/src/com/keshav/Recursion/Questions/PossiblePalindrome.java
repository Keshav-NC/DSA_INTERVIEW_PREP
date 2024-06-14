package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class PossiblePalindrome {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(possiblePalindrome("", s));
    }

    private static List<List<String>> possiblePalindrome(String p, String up) {
        if (up.isEmpty()) {
            List<String> internal = new ArrayList<>();
            internal.add(p);
            List<List<String>> list = new ArrayList<>();
            if (!internal.getFirst().isEmpty() && isPalindrome(internal.getFirst())) {
                list.add(internal);
            }
            return list;
        }

        char ch = up.charAt(0);

        List<List<String>> left = possiblePalindrome(p + ch, up.substring(1));
        List<List<String>> right = possiblePalindrome(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static boolean isPalindrome (String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(s.length() - i - 1);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
