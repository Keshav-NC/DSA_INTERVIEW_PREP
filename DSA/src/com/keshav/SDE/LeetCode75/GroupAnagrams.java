package com.keshav.SDE.LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"", ""};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashSet<String> seen = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; ++i) {
            String str1 = strs[i];
            List<String> sub = new ArrayList<>();
            if (!seen.contains(str1)) {
                sub.add(str1);
                seen.add(str1);
            }
            for (int j = i + 1; j < strs.length; ++j) {
                String str2 = strs[j];
                if (!seen.contains(str2) && isAnagram(str1, str2)) {
                    sub.add(str2);
                    seen.add(str2);
                }
            }
            if (!sub.isEmpty()) {
                res.add(new ArrayList<>(sub));
            }
        }
        return res;
    }

    private static boolean isAnagram(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n != m) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n; i++) {
            ++freq1[str1.charAt(i) - 'a'];
            ++freq2[str2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
