package com.keshav.Stacks.Questions;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{[()[]]{}}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        int n = s.length();
        // odd case
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                char top = stack.peek();
                stack.pop();

                if (top != '(' && ch == ')' || top != '{' && ch == '}' || top != '[' && ch == ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
