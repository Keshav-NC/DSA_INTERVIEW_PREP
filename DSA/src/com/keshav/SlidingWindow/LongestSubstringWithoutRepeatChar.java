package com.keshav.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatChar {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;

        while (end < n) {
            char ch = s.charAt(end);
            // if (set.contains(ch)) {
            if (map.containsKey(ch) && map.get(ch) >= start) {
                // shrinking
                // while (start < end && set.contains(ch)) {
                //     set.remove(s.charAt(start));
                //     ++start;
                // }
                start = map.get(ch) + 1;
            }
            // set.add(ch);
            map.put(ch, end);
            maxLength = Math.max(maxLength, end - start + 1);
            ++end;
        }
        return (maxLength == Integer.MIN_VALUE) ? 0 : maxLength;
    }
}
