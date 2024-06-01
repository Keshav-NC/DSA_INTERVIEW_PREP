package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsequences {
    public static void main(String[] args) {
//        subSequence("", "abc");
        System.out.println(subSequenceAL("", "abc"));

    }

    static void subSequence (String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            System.out.print(processed + " ");
            return;
        }

        char ch = unprocessed.charAt(0);
        subSequence(processed + ch, unprocessed.substring(1));
        subSequence(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subSequenceAL (String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subSequenceAL(processed + ch, unprocessed.substring(1));
        ArrayList<String> right = subSequenceAL(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }
}
