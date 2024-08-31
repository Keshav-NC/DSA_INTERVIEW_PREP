package com.keshav.Maths.BitwiseOperator;

public class NumberCompliment {
    public static void main(String[] args) {
        int num = 5;

        // find the length of given number (binary format)
        int length = (int)(Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << length) - 1;
        System.out.println(mask ^ num);
    }
}
