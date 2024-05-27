package com.keshav.LinearSearching;

public class LSArraysMin {
    public static void main(String[] args) {
        int[] arr = {34, 67, -56, -100, 45, 100, 200};
        int ans = linearSearchMin(arr);
        System.out.println(ans);
    }

    static int linearSearchMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }
}
