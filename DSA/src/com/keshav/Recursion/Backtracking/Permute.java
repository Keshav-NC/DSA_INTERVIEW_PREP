package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        String s = "aab";
        List<String> ans = new ArrayList<>();
        permute(new StringBuilder(s), 0, ans);
        System.out.println(ans);
    }

    private static void permute(StringBuilder s, int start, List<String> ans) {
        if (start == s.length() - 1) {
            ans.add(s.toString());
            return ;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                swap(s, start, i);
                permute(s, start + 1, ans);
                swap(s, start, i);
            }
        }
    }
    private static void swap(StringBuilder s, int start, int i) {
        // for string
        char temp = s.charAt(start);
        s.setCharAt(start, s.charAt(i));
        s.setCharAt(i, temp);

//        // for integer
//        int temp = nums[start];
//        nums[start] = nums[i];
//        nums[i] = temp;
    }
}
