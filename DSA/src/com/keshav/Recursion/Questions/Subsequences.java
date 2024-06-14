package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {
        subSequence("", "aab");
//        subSeqAscii("", "abc");
//        System.out.println(subSeqAsciiAL("", "abc"));

    }

    static void subSequence (String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            System.out.print(processed + " ");
            return;
        }

        char ch = unprocessed.charAt(0);

        // we have two choices
        // take it
        subSequence(processed + ch, unprocessed.substring(1));
        // ignore it
        subSequence(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subSequenceAL (String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            //  if str is empty, just add in list and return
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        // take it, inserting in ArrayList of left
        ArrayList<String> left = subSequenceAL(processed + ch, unprocessed.substring(1));
        // ignore it, inserting in ArrayList of right
        ArrayList<String> right = subSequenceAL(processed, unprocessed.substring(1));
        // add all the char's of right list into left list
        left.addAll(right);
        return left;
    }

    static void subSeqAscii (String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            System.out.print(processed + " ");
            return;
        }

        char ch = unprocessed.charAt(0);
        // for every char we have two choices
        // take it
        subSeqAscii(processed + ch, unprocessed.substring(1));
        // ignore it
        subSeqAscii(processed, unprocessed.substring(1));
        // here including ASCII value
        subSeqAscii(processed + (int)(ch), unprocessed.substring(1));
    }

    static ArrayList<String> subSeqAsciiAL (String processed, String unprocessed) {

        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        ArrayList<String> first = subSeqAsciiAL(processed + ch, unprocessed.substring(1));
        ArrayList<String> second = subSeqAsciiAL(processed, unprocessed.substring(1));
//        ArrayList<String> third= subSeqAsciiAL(processed + (int)(ch), unprocessed.substring(1));

        first.addAll(second);
//        first.addAll(third);
        return first;
    }
}
