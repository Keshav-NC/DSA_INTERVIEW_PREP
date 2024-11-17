package com.keshav.SDE.LeetDaily;

import java.util.HashMap;
import java.util.Map;

public class StringCompressionII {
    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaabb";
        System.out.println(compression(word));
    }

    private static String compression(String word) {
        int n = word.length();
        StringBuilder comp = new StringBuilder();
        for (int i = 0, j = 0; i < n; i = j) {
            int count = 0;
            while (j < n && word.charAt(i) == word.charAt(j) && count < 9) {
                ++j;
                ++count;
            }
            comp.append(count).append(word.charAt(i));
        }
        return comp.toString();
    }
}
