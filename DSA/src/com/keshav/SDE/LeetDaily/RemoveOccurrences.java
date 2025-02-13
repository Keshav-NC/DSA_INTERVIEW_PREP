package com.keshav.SDE.LeetDaily;

import java.util.Stack;

public class RemoveOccurrences {
    public static void main(String[] args) {
        String s = "axxxxyyyyb";
        String part = "xy";
        System.out.println(removeOccurrences(s, part));
    }

    private static String removeOccurrences(String s, String part) {
//        StringBuilder sb = new StringBuilder();
//        int n = part.length();
//        for (char ch : s.toCharArray()) {
//            sb.append(ch);
//            int start = sb.length() - n;
//            int end = sb.length();
//
//            while (sb.length() >= n && sb.substring(start).equals(part)) {
//                sb.delete(start, end);
//            }
//        }
//        return sb.toString();

        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
