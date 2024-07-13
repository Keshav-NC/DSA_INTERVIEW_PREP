package com.keshav.SDE.LeetCode75;

public class GCDofStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    static int gcd (int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    static String gcdOfStrings (String str1, String str2) {
        StringBuilder res = new StringBuilder();
        if ((str1 + str2).equals(str2 + str1)) {
            int x = gcd (str1.length(), str2.length());
            for (int i = 0; i < x; i++) {
                res.append(str1.charAt(i));
            }
        } else {
            return "";
        }
        return res.toString();
    }
}
