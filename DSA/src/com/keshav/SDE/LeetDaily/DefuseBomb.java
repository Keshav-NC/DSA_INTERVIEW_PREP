package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class DefuseBomb {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = code[i];
            arr[n + i] = code[i];
        }
        System.out.println(Arrays.toString(arr));
        int index = 0;
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += arr[j+i+1];
                }
                res[i] = sum;
            }
        } else {
            for (int i = n-1; i >= 0; i++) {
                int sum = 0;
                k = 1-k;
                for (int j = 0; j < k; ++j) {
                }
            }
        }
        return res;
    }
}
