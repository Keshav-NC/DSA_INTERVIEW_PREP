package com.keshav.SDE.LeetDaily;

import java.util.HashSet;

public class MakeStringSubsequenceCyclic {
    public static void main(String[] args) {
        String str1 = "am";
        String str2 = "zd";
        System.out.println(canMakeSubsequence(str1, str2));
    }

    private static boolean canMakeSubsequence(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1);
        int i = 0;
        int j = 0;
        while (i < sb.length() && j < str2.length()) {
            char ch = sb.charAt(i);
            if (ch == str2.charAt(j) || (ch == 'z' ? 'a' : (char)(ch + 1)) == str2.charAt(j)) {
                ++i;
                ++j;
            } else {
                ++i;
            }
        }
        return (j == str2.length());
    }
}
