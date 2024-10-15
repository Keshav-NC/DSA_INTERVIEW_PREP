package com.keshav.SDE.LeetDaily;

public class SeparateBlackWhite {
    public static void main(String[] args) {
        String s = "0111";
        System.out.println(minimumSteps (s));
    }

    private static long minimumSteps(String s) {
        int n = s.length();
        long minStep = 0;
        long count = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                minStep += count;
            }
            if (s.charAt(i) == '0') {
                ++count;
            }
        }
        return minStep;
    }
}
