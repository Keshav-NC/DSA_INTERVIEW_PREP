package com.keshav.SDE;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
public class Pangram {
    public static void main(String[] args) {
        String str = "Saket KP ";
        System.out.println(pangram(str));

    }

    static boolean pangram(String str) {
        Set<Character> seen = new HashSet<>();
        for (char ch : str.toCharArray()) {
            seen.add(ch);
        }
        return seen.size() == 26;
    }

    static boolean isPangram (String str) {
        for (char ch = 'a'; ch <= 'z' ; ch++) {
            if (!str.contains(Character.toString(ch))) {
                return false;
            }
        }
        return true;
    }
}
