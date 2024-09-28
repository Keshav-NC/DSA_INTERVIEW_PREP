package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashMap;

public class SumPrefix {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(sumPrefix(words)));
    }

    private static int[] sumPrefix(String[] words) {
        int[] ans = new int[words.length];
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            String w = "";
            for (int i = 0; i < word.length(); i++) {
                w += word.charAt(i);
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }

        int i = 0;
        for (String word : words) {
            String w = "";
            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                w += word.charAt(j);
                if (freq.containsKey(w)) {
                    count += freq.get(w);
                }
            }
            ans[i++] = count;
        }
        return ans;
    }
}
