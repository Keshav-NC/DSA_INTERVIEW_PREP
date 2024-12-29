package com.keshav.Stacks.Questions;

import java.util.Stack;

public class FindCelebrity {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
        };
        System.out.println(findCelebrity(matrix));
    }

    private static int findCelebrity(int[][] matrix) {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        // Push everybody to stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        // Extract top 2
        // Find potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            // a does not know b --> a maybe celebrity
            if (knowsMe(a, b, matrix)) {
                stack.push(a);
            } else { // b maybe celebrity
                stack.push(b);
            }
        }
        // Potential candidate
        int celeb = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != celeb && (matrix[celeb][i] != 0 || matrix[i][celeb] != 1)) {
                return -1;
            }
        }
        return celeb;
    }

    private static boolean knowsMe(int a, int b, int[][] matrix) {
        return (matrix[a][b] == 0);
    }
}
