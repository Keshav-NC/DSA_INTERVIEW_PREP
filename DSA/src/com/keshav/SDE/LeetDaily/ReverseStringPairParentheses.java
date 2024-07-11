package com.keshav.SDE.LeetDaily;

import java.util.Stack;

public class ReverseStringPairParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverse(s));
    }

    static String reverse (String s) {
        int n = s.length();
        int[] index = new int[n];
        Stack<Integer> stack = new Stack<>(); // store index of opening and closing index and swap
        StringBuilder res = new StringBuilder();

        // store the index of opening parentheses in the index array
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                // swap the indices
                // ( e d ( e t ( o c ) ) e l )
                // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
                // index = [13 .....  0]
                //           0         13

                int openIndex = stack.pop();
                index[openIndex] = i;
                index[i] = openIndex;
            }
        }

        // direction = 1 --> forward (default)
        // direction = -1 --> backward
        int i = 0;
        int direction = 1;

        while ( i < n) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                // jump to the either closing or opening parentheses as per the above condition
                i = index[i];
                // change direction after jump to the respected open or close parentheses
                direction *= -1;
            } else {
                res.append(ch);
            }
            // move to the specified direction
            i += direction;
        }
        return res.toString();
    }
}
