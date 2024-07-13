package com.keshav.SDE.LeetCode75;

public class MergerStrings {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "pqrs";
        System.out.println(merge(s1, s2));
    }

    static String merge (String s1, String s2) {
        StringBuilder res = new StringBuilder();
        if (s1.length() > s2.length()) {
            for (int i = 0; i < s2.length(); i++) {
                res.append(s1.charAt(i)).append(s2.charAt(i));
            }
            res.append(s1.substring(s2.length()));
        } else {
            for (int i = 0; i < s1.length(); i++) {
                res.append(s1.charAt(i)).append(s2.charAt(i));
            }
            res.append(s2.substring(s1.length()));
        }
        return res.toString();
    }
}
