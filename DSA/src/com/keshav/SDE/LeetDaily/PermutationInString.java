package com.keshav.SDE.LeetDaily;

import java.util.HashSet;
import java.util.LinkedList;

public class PermutationInString {
    public static void main(String[] args) {
        HashSet<String> permute = new HashSet<>();
        System.out.println(checkInclusion("adc", "dcda", permute));
    }

    public static boolean checkInclusion(String s1, String s2, HashSet<String> permute) {
        int n = s2.length();
        int windowSize = s1.length();
        int i = 0;
        int j = windowSize-1;

        permutation("", s1, permute);

        while (j < n) {
            String str = s2.substring(i, j+1);
            if (permute.contains(str)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static void permutation(String p, String up, HashSet<String> permute) {
        if (up.isEmpty()) {
            if (!p.isEmpty()) {
                permute.add(p);
            }
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            permutation(first + ch + second, up.substring(1), permute);
        }
    }
}
