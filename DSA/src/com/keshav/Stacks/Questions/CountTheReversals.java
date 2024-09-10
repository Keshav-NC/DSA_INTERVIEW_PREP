package com.keshav.Stacks.Questions;

import java.util.Stack;

public class CountTheReversals {
    public static void main(String[] args) {
        String s = "}{{}}{{{";
        System.out.println(count(s));
    }


    // Using stack O(n + k)
    private static int count(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                // insert in case of invalid pair }} or close comes before open
                if (stack.isEmpty() || stack.peek() == '}') {
                    stack.push(ch);
                } else {
                    // remove the valid pairs
                    stack.pop();
                }
            }
        }
        int ans = 0;
        int open = 0;
        int close = 0;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (top == '{') ++open;
            else ++close;
        }
        ans = (int)(Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
        return ans;
    }

    public static int countWithoutStacks(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return -1;
        }
//        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                ++open; //stack.push(ch);
            } else {
                // insert in case of invalid pair }} or close comes before open
//                if (stack.isEmpty() || stack.peek() == '}') {
                if (open <= 0) {
                    ++close; //stack.push(ch);
                } else {
                    // remove the valid pairs
                    open--; //stack.pop();
                }
            }
        }

//        while (!stack.isEmpty()) {
//            int top = stack.pop();
//            if (top == '{') ++open;
//            else ++close;
//        }
        ans = (int)(Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
        return ans;
    }
}
