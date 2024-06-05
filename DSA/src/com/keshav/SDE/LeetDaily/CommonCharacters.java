package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonCharacters(words));
    }

    private static List<String> commonCharacters(String[] words) {
        int[] commonCount = new int[26];
        String firstWord = words[0];
        for (char ch : firstWord.toCharArray()) {
            int index = ch - 'a'; // a=0, b=1, ...... ,z=25
            commonCount[index]++;
        }
        int n = words.length;
        for (int i = 1; i < n; i++) {
            String curWord = words[i];
            int[] count = new int[26];
            for (char ch : curWord.toCharArray()) {
                // converting char to int --> array index a=0, b=1 ... , z=25
                int index = ch - 'a';
                count[index]++;
            }
            // update commonCount with min values
            for (int j = 0; j < 26; j++) {
                commonCount[j] = Math.min (commonCount[j], count[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            // skip zero's
            if (commonCount[i] != 0) {
                // converting int to char
                char ch = (char)(97 + i);
                int c = commonCount[i];
                while (c > 0) {
                    res.add("" + ch);
                    c--;
                }
            }
        }
        return res;
    }
}