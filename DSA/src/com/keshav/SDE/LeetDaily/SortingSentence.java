package com.keshav.SDE.LeetDaily;

import com.sun.jdi.ArrayReference;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;

public class SortingSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    private static String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            String word = words[i];
            sb.append(word, 0, word.length() - 1);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
