package com.keshav.SlidingWindow;

import java.util.Arrays;

public class CountOccurenceOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(count(txt, pat));
    }
    public static int count(String txt, String pat) {
        int windowSize = pat.length();
        int n = txt.length();
        int[] freqPat = new int[26];
        int[] freqTxt = new int[26];
        int count = 0;

        // freq map of pattern --> pat
        for (int i = 0; i < windowSize; i++) {
            int index1 = pat.charAt(i) - 'a';
            freqPat[index1]++;
            int index2 = txt.charAt(i) - 'a';
            freqTxt[index2]++;

        }

//        // first window
//        for (int i = 0; i < windowSize; i++) {
//            int index = txt.charAt(i) - 'a';
//            freqTxt[index]++;
//        }

        if (Arrays.equals(freqTxt, freqPat)) {
            ++count;
        }

        for (int i = 1; i < n-windowSize+1; i++) {
            int remove = txt.charAt(i-1) - 'a';
            int add = txt.charAt(i+windowSize-1) - 'a';
            --freqTxt[remove];
            ++freqTxt[add];
            if (Arrays.equals(freqTxt, freqPat)) {
                ++count;
            }
        }
        return count;
    }
}
