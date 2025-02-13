package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowel {
    public static void main(String[] args) {
        String[] words = {"a","e","i"};
        int[][] queries = {{0,2},{0,1},{2,2}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    private static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int[] prefix = new int[words.length];
        prefix[0] = (isVowel(words[0].charAt(0), vowels) && isVowel(words[0].charAt(words[0].length() - 1), vowels) ? 1 : 0);

        for (int i = 1; i < words.length; i++) {
            boolean start = isVowel(words[i].charAt(0), vowels);
            boolean end = isVowel(words[i].charAt(words[i].length() - 1), vowels);
            if (start && end) {
                prefix[i] = prefix[i-1] + 1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }
        int[] res = new int[n];
        int j = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            if (l == 0 || r == 0) {
                res[j++] = prefix[r];
            } else {
                res[j++] = prefix[r] - prefix[l - 1];
            }
        }
        System.out.println(Arrays.toString(prefix));
        return res;
    }
    private static boolean isVowel(char ch, Set<Character> vowels) {
        return vowels.contains(ch);
    }
}
