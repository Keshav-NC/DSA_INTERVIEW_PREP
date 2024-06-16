package com.keshav.Maths.BitwiseOperator;

public class BinaryToDec {
    public static void main(String[] args) {
//        int[] binary = {1, 1};
//        System.out.println(binaryToDecimalArr(binary));
        System.out.println(dToB(2));
    }

    private static int binaryToDecimalArr(int[] binary) {
        int dec = 0;
        int base = 1;

        for (int i = binary.length-1; i >=0 ; i--) {
            dec += binary[i] * base;
            base *= 2;
        }
        return dec;
    }

    static int dToB(int num) {
        int binary = 0;
        int i = 0;
        while (num != 0) {
            int bit = num & 1;
            binary += (bit * (int) Math.pow(10, i++));
            num >>= 1;
        }
        return binary;
    }
}
