package com.keshav.SDE.LeetDaily;

public class CountPrefixSuffix {
    public static void main(String[] args) {
        String[] words = {"pa","papa","ma","mama"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    private static int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        if (n < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String str1 = words[i];
                String str2 = words[j];
                if (isPrefixSuffix(str1, str2)) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static boolean isPrefixSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
