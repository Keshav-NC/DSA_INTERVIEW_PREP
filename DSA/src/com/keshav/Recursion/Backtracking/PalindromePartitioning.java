package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<List<String>> ans;
    public static void main(String[] args) {
        String s = "aab";
        ans = new ArrayList<>();
        partitions(s, new ArrayList<>(), 0);
        System.out.println(ans);
    }

    private static void partitions(String s, List<String> sub, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(sub)); // copy to avoid reference issues
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                sub.add(sb.toString());
                partitions(s, sub, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(StringBuilder pal) {
        for (int i = 0; i < pal.length()/2; ++i) {
            if (pal.charAt(i) != pal.charAt(pal.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
