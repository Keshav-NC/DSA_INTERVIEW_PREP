package com.keshav.SDE.LeetDaily;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        String s = "ABFCACDB";
//        StringBuilder str = new StringBuilder(s);
//        str.delete(0, 2);
//        System.out.println(str);

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            if (s.contains("CD")) {
                s = s.replace("CD", "");
            }
        }

        System.out.println(s.length());
//        System.out.println(minimumStringLength(s));
    }

    private static int minimumStringLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = 1;
        int n = sb.length();

        while (j < sb.length()) {
            if ((sb.charAt(i) == 'A' && sb.charAt(j) == 'B') || (sb.charAt(i) == 'C' && sb.charAt(j) == 'D')) {
                sb.delete(i, j+1);
                i = 0;
                j = 1;
            } else {
                ++i;
                ++j;
            }
        }
        return sb.length();
    }
}
