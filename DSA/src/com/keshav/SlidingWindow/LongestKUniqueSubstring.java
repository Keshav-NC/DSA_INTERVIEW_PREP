package com.keshav.SlidingWindow;

public class LongestKUniqueSubstring {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(uniqueSubstring(s, k));
    }

    private static int uniqueSubstring(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        int len = 0;
        int uniqueCharCount = 0;
        int[] freq = new int[26];
        int start = 0;
        int end = 0;

        while (end < n) {
            // freq --> a - 0, b - 1 ... z - 25
            int index = s.charAt(end) - 'a';
            // appears first time
            if (freq[index] == 0) {
                ++uniqueCharCount;
                freq[index]++;
            } else {
                freq[index]++;
            }
            // calculate length of substring
            if (uniqueCharCount == k) {
                len = end - start + 1;
                maxLength = Math.max(maxLength, len);
            }
            // shrinking
            else if (uniqueCharCount > k) {
                while (start < end && uniqueCharCount > k) {
                    index = s.charAt(start) - 'a';
                    freq[index]--;
                    if (freq[index] == 0) {
                        --uniqueCharCount;
                    }
                    ++start;
                }
            }
            ++end;
        }
        return maxLength;
    }
}
