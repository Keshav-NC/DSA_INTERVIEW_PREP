package com.keshav.SDE;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "racer";
        System.out.println(valid(s));
    }

    private static boolean valid(String s) {
        s = s.toLowerCase();
        String newS = "";
        String pattern = "^[a-zA-Z0-9]*$";

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                newS += ch;
            }
        }
        return isPalindrome(newS);
    }

    static boolean isPalindrome (String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(s.length() - i - 1);
            if (start != end) {
                return false;
            }
        }
        return true;
    }

}
