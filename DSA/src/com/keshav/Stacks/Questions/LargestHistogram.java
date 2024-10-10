package com.keshav.Stacks.Questions;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

     static int n;
    // TC : O(5N)
    public static int[] findNextSmaller (int[] heights) { // O(2N)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n]; // store index
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }
    public static int[] findPrevSmaller (int[] heights) { // O(2N)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n]; // store index
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
    public static int largestRectangleArea(int[] heights) {
        n = heights.length;
        int[] nextSmaller = findNextSmaller(heights);
        int[] prevSmaller = findPrevSmaller(heights);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // O(N)
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1; // both exclusive
            max = Math.max(max, height * width);
        }
        return max;
    }
}
