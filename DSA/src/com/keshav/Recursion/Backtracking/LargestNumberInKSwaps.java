package com.keshav.Recursion.Backtracking;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;

public class LargestNumberInKSwaps {
    public static void main(String[] args) {
        String str = "4551711527";
        int k = 4;
        StringBuilder sb = new StringBuilder(str);
        String[] res = {str};
        largestNumber(sb, 0, k, res);
        System.out.println(Arrays.toString(res));
    }

    private static void largestNumber(StringBuilder str, int start, int k, String[] res) {
        if (k == 0 || start == str.length() - 1) {
            return;
        }
        int maxIndex = getMax(start + 1, str);

        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(maxIndex)) {
                swap(str, start, maxIndex);
                // lex compare
                if (str.toString().compareTo(res[0]) > 0) {
                    res[0] = str.toString();
                }
                largestNumber(str, start + 1, k - 1, res);
                swap(str, start, maxIndex);
            }
        }
        largestNumber(str, start + 1, k, res);
    }

    private static int getMax(int start, StringBuilder str) {
        int max = start;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(max) < str.charAt(i)) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(StringBuilder str, int start, int i) {
        char temp = str.charAt(start);
        str.setCharAt(start, str.charAt(i));;
        str.setCharAt(i, temp);
    }
}
