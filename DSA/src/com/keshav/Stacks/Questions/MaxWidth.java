package com.keshav.Stacks.Questions;

import java.util.Stack;

public class MaxWidth {
    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidth(nums));
    }

    private static int maxWidth(int[] nums) {
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) { // O(N)
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }
            if (stack.isEmpty()) break;
        }
        return maxWidth;
    }
}
