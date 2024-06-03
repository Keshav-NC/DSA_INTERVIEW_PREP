package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(phoneAl("", "79"));
    }

    static void phonePad (String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert '2' to 2

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // this will convert 'a' + i=1 --> 97 + 1 --> 98 --> 'b'
            phonePad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> phoneAl (String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        int i = (digit - 2) * 3;
        if(digit > 7) {
            i+=1;
        }

        int to = i + 3;

        if(digit == 7 || digit == 9) {
            to += 1;
        }

        // local to this call
        ArrayList<String> list = new ArrayList<>();
        for (; i < to; i++) {
            char ch = (char) ('a' + i);
            list.addAll(phoneAl(p + ch, up.substring(1)));
        }
        return list;
    }
}
