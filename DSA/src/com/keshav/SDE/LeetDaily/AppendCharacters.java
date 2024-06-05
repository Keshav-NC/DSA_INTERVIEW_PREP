package com.keshav.SDE.LeetDaily;

public class AppendCharacters {
    public static void main(String[] args) {
        String s = "coding";
        String t = "coaching";
        System.out.println(appendCharacter(s, t));
    }

    static int appendCharacter (String s, String t) {
        int i = 0;
        int j = 0;

        int n = s.length();
        int m = t.length();

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return (m - j);
    }
}
