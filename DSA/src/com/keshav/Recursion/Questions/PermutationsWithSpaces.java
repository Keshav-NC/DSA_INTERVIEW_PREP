package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithSpaces {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(permutationWithSpaces(s));
    }

    private static List<String> permutationWithSpaces(String s) {
        List<String> ans = new ArrayList<>();
        solve("" + s.charAt(0), s.substring(1), ans);
        return ans;
    }

    private static void solve(String p, String up, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }
        char ch = up.charAt(0);
        // add space with char
        solve(p +"_" + ch, up.substring(1), ans);
        // not add space with char
        solve(p + ch, up.substring(1), ans);
    }
}
