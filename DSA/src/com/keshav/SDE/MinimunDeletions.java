package com.keshav.SDE;

import java.util.Arrays;

public class MinimunDeletions {
    public static void main(String[] args) {
        String str = "aac";
        minDel(str);
//        System.out.println(minDel(str));
    }

    private static void minDel(String str) {
        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            freq[index]++;
        }
//        System.out.println(Arrays.toString(freq));
        int count = 0;
        for (int i = 1; i < freq.length; i++) {
            if ( freq[i] != 0 && freq[i] == freq[i-1]) {
                count += 2;
            }
        }
        System.out.println(count);
    }
}
