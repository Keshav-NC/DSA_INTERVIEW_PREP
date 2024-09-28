package com.keshav.SDE.LeetDaily;

import java.util.HashSet;

public class LongestCommonPrefx {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 6};
        int[] arr2 = {7, 9};
        System.out.println(lcp(arr1, arr2));
    }

    private static int lcp(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        // all the possible prefix of arr1 stored in set
        for (int num : arr1) {
            while (num > 0) {
                if (!set.contains(num)) {
                    set.add(num);
                }
                num /= 10;
            }
        }

        int length = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    length = Math.max (length, (int) Math.log10(num) + 1);
                }
                num /= 10;
            }
        }
        return length;
    }
}
