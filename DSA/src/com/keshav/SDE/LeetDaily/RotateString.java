package com.keshav.SDE.LeetDaily;

import javax.print.DocFlavor;
import java.util.HashSet;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
//        System.out.println(rotateStringBF(s, goal));
        System.out.println(rotateString(s, goal));
    }

    private static boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        s = s.concat(s);
        System.out.println(s);

        return s.contains(goal);
    }

    // Brute force
    private static boolean rotateStringBF(String s, String goal) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(0);
            s = s.substring(1, n) + ch;
            set.add(s);
        }
        return (set.contains(goal));
    }
}
