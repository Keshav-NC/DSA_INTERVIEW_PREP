package com.keshav.Recursion.Questions;

import com.sun.security.jgss.GSSUtil;

import java.util.Stack;

public class DeleteMidStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
    }

    private static void deleteMid(Stack<Integer> stack) {
        int n = stack.size();
        int k = (n / 2) + 1; // mid index
        delete(stack, k);
    }

    private static void delete(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop(); // delete mid value
            return;
        }
        int top = stack.pop();
        delete(stack, k - 1);
        stack.push(top);
    }
}
