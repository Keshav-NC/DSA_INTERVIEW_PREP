package com.keshav.Stacks.Questions;

import java.util.Arrays;
import java.util.Stack;

public interface NextGreaterElement {
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 3};



//        System.out.println(Arrays.toString(NGE(arr)));
        System.out.println(Arrays.toString(NGEII(arr)));
    }

    static long[] NGEII(long[] arr) {
        long[] nums = new long[arr.length * 2];
        System.arraycopy(arr, 0, nums, 0, arr.length);
        System.arraycopy(arr, 0, nums, arr.length, arr.length);

        Stack<Long> stack = new Stack<>();
        int n = arr.length;
        long[] res = new long[n];

        for (int i = 2*n - 1; i >= n; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for (int i = n-1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    static long[] NGE(long[] arr) {
        int n = arr.length;
        Stack<Long> stack = new Stack<>();
        long[] res = new long[n];

        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
}
