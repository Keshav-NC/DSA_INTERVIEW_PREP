package com.keshav.Stacks.Questions;

public class MinimumSwaps {
    public static void main(String[] args) {
        String s = "[]][][";
        System.out.println(minimumNumberOfSwaps(s));
    }

    public static int minimumNumberOfSwaps(String S) {
        // code here
        int open = 0;
        int close = 0;
        int unbalanced = 0;
        int swaps = 0;

        for (char ch : S.toCharArray()) {
            if (ch == '[') {
                ++open;
                if (unbalanced > 0) {
                    swaps += unbalanced;
                    --unbalanced;
                }
            } else {
                ++close;
                unbalanced = close - open;
            }
        }
        return swaps;
    }
}