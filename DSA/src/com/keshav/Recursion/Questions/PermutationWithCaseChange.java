package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        String s = "3z4";
        System.out.println(caseChange(s));
    }

    private static List<String> caseChange(String s) {
        List<String> ans = new ArrayList<>();
        solve("", s, ans);
        return ans;
    }

    private static void solve(String p, String up, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }
        char ch = up.charAt(0);
        if (Character.isDigit(ch)) {
            solve(p + ch, up.substring(1), ans);
        }
        // lower case;
        if (Character.isLowerCase(ch)) {
            // same
            solve(p + ch, up.substring(1), ans);
            // to upper
            solve(p + Character.toUpperCase(ch), up.substring(1), ans);

        }
        if (Character.isUpperCase(ch)) {
            char lower = Character.toLowerCase(ch);
            // same
            solve(p + ch, up.substring(1), ans);
            // to lower
            solve(p + lower, up.substring(1), ans);
        }
    }
}
