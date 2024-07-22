package com.keshav.SDE.LeetDaily;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flight", "flow", "flower", "flaw"};
//        System.out.println(longestCommonPrefix(strs));
        System.out.println(lcpBs(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        String res = "";
        for (int i=0;i<strs[0].length();i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }
            res += strs[0].charAt(i);
        }
        return res;
    }

    static String lcpBs (String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min (minLen, str.length());
        }
        int start = 1;
        int end = minLen;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isCommonPrefix(strs, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return strs[0].substring(0, (start + end) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int mid) {
        String prefix = strs[0].substring(0, mid);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }
}
