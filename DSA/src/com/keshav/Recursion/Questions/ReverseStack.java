package com.keshav.Recursion.Questions;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);

    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        helper(stack, top);
    }

    private static void helper(Stack<Integer> stack, int bottom) {
        if (stack.isEmpty()) {
            stack.push(bottom);
            return;
        }
        int top = stack.pop();
        helper(stack, bottom);
        stack.push(top);
    }
}
