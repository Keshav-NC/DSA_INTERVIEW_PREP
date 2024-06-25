package com.keshav.Recursion.Questions;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        permutation("", str);
//        System.out.println(permuteList("", str));
//
//        System.out.println(permutationCount("", "abc"));
    }

    /*
            NOTE:
                - no of recursive calls = p.length + 1
                - no of position to place ch = p.length + 1
     */
    static void permutation (String p, String up) {

        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutation(first + ch + second, up.substring(1));
        }
    }

    static ArrayList<String> permuteList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        // local to this call
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            ans.addAll(permuteList(first + ch + second, up.substring(1)));
        }
        return ans;
    }

    static int permutationCount (String p, String up) {

        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            count = count + permutationCount(p.substring(0, i) + up.charAt(0) + p.substring(i), up.substring(1));
        }
        return count;
    }

}
