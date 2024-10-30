package com.keshav.SDE.LeetDaily;

public class KthBitString {
    public static void main(String[] args) {
        int n = 4;
        int k = 11;
        System.out.println(kthBit(n, k));
//        System.out.println(invert("10000"));
    }

    private static char kthBit(int n, int k) {
//        String left = "0";
        StringBuilder left = new StringBuilder("0");
        for (int i = 1; i < n; ++i) {
//            left = (left + "1" + invert(left));
            left.append(left);
            left.append("1");
            left.append(invert(left));
        }
        return left.charAt(k-1);
    }
    private static String invert(StringBuilder bits) {
        StringBuilder invert = new StringBuilder();
        for (int i = 0; i < bits.length(); ++i) {
            char bit = bits.charAt(i);
//            if (bit == '0') {
//                invert.append("1");
//            }
//            if (bit == '1') {
//                invert.append("0");
//            }
            invert.append((bit == '0') ? "1" : "0");
        }
        return invert.reverse().toString();
    }
}
