package com.ArraysQuestions.Strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "absba";
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome (String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        str = str.toLowerCase();

        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-i-1);
            if (start != end) {
                return false;
            }
        }
        return true;
    }

}
