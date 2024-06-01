package com.keshav.SDE;

//https://leetcode.com/problems/score-of-a-string/submissions/1273810102/?envType=daily-question&envId=2024-06-01
public class ScoreOfString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(score(s));
        System.out.println(helper(s, 0, 0));
    }

    private static int score(String s) {
        int diff;
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            diff = Math.abs(s.charAt(i) - s.charAt(i+1));
            sum += diff;
        }
        return sum;
    }

    static int helper (String s, int sum, int i) {
        if (i == s.length()-1) {
            return sum;
        }

        return helper(s, sum + Math.abs(s.charAt(i) - Math.abs(s.charAt(i+1))), ++i);
    }
}
