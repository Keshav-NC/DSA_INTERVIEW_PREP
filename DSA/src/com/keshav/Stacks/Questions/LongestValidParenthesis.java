package com.keshav.Stacks.Questions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
//        String s = ")()()))()(())()()(";
        String s = "(()";
//        System.out.println(longest(s));
        longest(s);
    }

    private static void longest(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty() || s.charAt(stack.peek()) == ')') { // ch == )
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        list.addFirst(-1);;
        list.addLast(s.length());
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(max, list.get(i+1) - list.get(i) - 1);
        }
        System.out.println(list);
        System.out.println(max);
    }
}
