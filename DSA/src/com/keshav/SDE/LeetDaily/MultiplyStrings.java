package com.keshav.SDE.LeetDaily;

import java.math.BigInteger;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "498828660196";
        String num2 = "840477629533";
        long num = 498828660;
        System.out.println((int)Math.log10(num)+1);
        System.out.println(multiply(num1, num2));
    }

    private static String multiply(String num1, String num2) {
        BigInteger ans = new BigInteger(num1).multiply(new BigInteger(num2));
        return String.valueOf(ans);
    }
}
