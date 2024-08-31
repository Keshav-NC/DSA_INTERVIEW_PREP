package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashMap;

public class KthDistinctString {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr, k));

    }

    private static String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String[] temp = new String[map.size()];
        int count = 0;
        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;
            }
            if (count == k) {
                return s;
            }
        }
        return "";
    }
}
