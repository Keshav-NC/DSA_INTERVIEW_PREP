package com.keshav.SDE.LeetDaily;

import java.util.Stack;

public class ShortestSubarryToRemoveMakeSorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,0,2,7,8,9};
        System.out.println(findLengthOfShortestSubarry(arr));
    }

    private static int findLengthOfShortestSubarry(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (!stack.isEmpty() && num == 0) {
                stack.pop();
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > num) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(num);
            }
        }
        System.out.println(stack);
        return (n - stack.size());
    }
}
