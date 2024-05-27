package com.keshav.Maths.BitwiseOperator;

public class UniqueNumber {
    public static void main(String[] args) {
        // works only for max two numbers are same with one unique number
        int[] arr = {1, 2, 2, 1, 4, 4, 5, 6, 6, 7, 7};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n; // ^ --> XOR operator
        }
        return unique;
    }
}
