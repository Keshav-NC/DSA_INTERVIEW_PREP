package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        System.out.println(wordSubsets(words1, words2));
    }

    private static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq2 = new int[26];
        for (String word2 : words2) {
            int[] temp = new int[26];
            for (char ch : word2.toCharArray()) {
                ++temp[ch - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                freq2[i] = Math.max(freq2[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word1 : words1) {
            int[] freq1 = new int[26];
            boolean flag = true;
            for (char ch : word1.toCharArray()) {
                ++freq1[ch - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                if (freq1[i] < freq2[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word1);
            }
        }
        System.out.println(Arrays.toString(freq2));
        return res;
    }
}
