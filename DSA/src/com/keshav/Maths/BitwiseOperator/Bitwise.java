package com.keshav.Maths.BitwiseOperator;

public class Bitwise {
    public static void main(String[] args) {
//        bitWise(4, 6);
        leftRightShift();
    }

    static void bitWise(int a, int b) {

        // AND --> &
        /*
            4 --> 100
            6 --> 110
            & --> 100 --> 4
         */
        System.out.println(a&b);
        // OR --> |
        /*
            4 --> 100
            6 --> 110
            | --> 110 --> 6
         */
        System.out.println(a|b);
        // XOR --> ^
        /*
            4 --> 100
            6 --> 110
            ^ --> 010 --> 2
         */
        System.out.println(a^b);
        // NOT --> ~
        /*
            int --> 32 byte
            2 -->  000000...100
            ~a-->  111111...011 --> msb == 1 means -ve
            1's -->000000   100
            2's              +1
                   ------------
                   000000...101 --> -5
         */
        System.out.println(~a);
    }

    static void leftRightShift() {

        /*
            NOTE : left shift always multiplies by 2 but only for smaller number
            NOTE : right shift always divides by 2
         */
        System.out.println(4 << 1);
        System.out.println(4 << 2);
        System.out.println(19 >> 1);
        System.out.println(19 >> 2);
    }
}
