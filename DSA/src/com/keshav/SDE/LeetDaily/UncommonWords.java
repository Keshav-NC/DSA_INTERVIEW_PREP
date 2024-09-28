package com.keshav.SDE.LeetDaily;

import java.util.*;

public class UncommonWords {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommon(s1, s2)));
    }
    public static String[] uncommon(String s1, String s2) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String str : s1.split(" ")) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }
        for (String str : s2.split(" ")) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        String[] res = new String[ans.size()];
        ans.toArray(res);
        return res;
    }
}
