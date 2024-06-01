package com.keshav.SDE;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
public class Pangram {
    public static void main(String[] args) {
        String str = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(isPangram(str));

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
