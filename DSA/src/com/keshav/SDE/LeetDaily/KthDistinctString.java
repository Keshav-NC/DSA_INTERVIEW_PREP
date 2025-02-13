package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashMap;

public class KthDistinctString {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinctArr(arr, k));

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

    public static String kthDistinctArr(String[] arr, int k) {
        int[][] freq = new int[26][2];
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            char ch = arr[i].charAt(0);
            ++freq[ch - 'a'][0];
            freq[i][1] = i;
        }
        char ans;
        for (int i = 0; i < 26; ++i, --k) {
            if (freq[i][0] == 1 && k > 0) {
                ans = (char)(i + 'a');
                return ans + "";
            }
        }
        return "";
    }
}
