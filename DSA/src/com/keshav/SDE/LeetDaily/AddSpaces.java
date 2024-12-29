package com.keshav.SDE.LeetDaily;

public class AddSpaces {
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces(s, spaces));
    }

    private static String addSpaces(String s, int[] spaces) {
         StringBuilder sb = new StringBuilder();
         int i = 0;
         int j = 0;
         while (i < s.length()) {
             if (j < spaces.length &&  i == spaces[j]) {
                 sb.append(' ');
                 ++j;
             }
             sb.append(s.charAt(i));
             ++i;
         }
         return sb.toString();
    }
}
