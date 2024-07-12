package com.keshav.SDE.LeetDaily;

import javax.imageio.ImageTranscoder;
import java.util.ArrayList;
import java.util.Stack;

public class MaxScoreRemoveSS {

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        System.out.println(maxScore(s, 4, 5));;
    }

    // global
//    static String str; --> string manipulation consumes more time

    static char[] str;
    static int maxScore (String s, int x, int y) {
//        str = s;
        int n = s.length();
        str = new char[n];

        for (int i = 0; i < n; i++) {
            str[i] = s.charAt(i);
        }

        String firstPair = (x > y) ? "ab" : "ba";
        String secPair = (firstPair.equals("ab")) ? "ba" : "ab";

        int score = 0;

        // first pass : remove substring in firstPair
        score = removeSubstring (firstPair, Math.max(x, y));

        // second pass : remove substring in secPair
        score += removeSubstring (secPair, Math.min(x, y));

        return score;
    }

    public static int removeSubstring (String pair, int score) {
        Stack<Character> stack = new Stack<>();
        int totalScore = 0;
        char firstChar = pair.charAt(0);
        char secChar = pair.charAt(1);

        for (char ch : str) {
            if (ch == secChar && !stack.isEmpty() && stack.peek() == firstChar) {
                totalScore += score;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        int ind = stack.size();
        str = new char[ind]; // resize

        for (int i = ind - 1; i >= 0; i--) {
            str[i] =stack.pop();
        }
        return totalScore;
    }
}
