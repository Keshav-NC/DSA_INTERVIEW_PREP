package com.keshav.SDE.LeetDaily;

public class CircularSentence {
    public static void main(String[] args) {
        String s = "a b c d e a";
        System.out.println(circularSentence(s));
    }

    private static boolean circularSentence(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        if (n == 1 && words[0].charAt(0) != words[0].charAt(words[0].length() - 1)) {
            return false;
        }
        if (words[0].charAt(0) != words[n-1].charAt(words[n-1].length() - 1)) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            char start = words[i].charAt(0);
            char end = words[i-1].charAt(words[i-1].length() - 1);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
