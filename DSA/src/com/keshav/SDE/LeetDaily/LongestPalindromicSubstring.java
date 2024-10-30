package com.keshav.SDE.LeetDaily;

import java.util.HashSet;
import java.util.Map;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int max = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub)) {
                    if (max < sub.length()) {
                        ans = new StringBuilder();
                        max = sub.length();
                        ans.append(sub);
                    }
                }
            }
        }
        System.out.println(max);
        return ans.toString();
    }

    private static boolean isPalindrome (String s) {
        int start = 0;
        int end = s.length()-1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
