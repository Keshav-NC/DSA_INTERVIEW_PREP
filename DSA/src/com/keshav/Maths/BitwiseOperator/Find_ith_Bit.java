package com.keshav.Maths.BitwiseOperator;

public class Find_ith_Bit {
    public static void main(String[] args) {
        int num = 1010110;
        int index = 4;
        System.out.println(findIthBit(num, index));
        System.out.println(setIthBit(num, index));
    }

    private static int setIthBit(int num, int index) {
        return num | (1 << (index-1));
    }

    private static int findIthBit(int num, int index) {
        return num & (1 << (index-1));
    }

}

