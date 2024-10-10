package com.keshav.Stacks.Questions;

import java.util.Arrays;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 3, 4, 5};
        System.out.println(Arrays.toString(PSE(arr)));
    }

    private static int[] PSE(int[] arr) {
        // custom stack
        int n = arr.length;
        int[] stack = new int[n+1];
        int[] res = new int[n];
        int index = -1;

        for (int i = 0; i < n; i++) {
            while (index != -1 && stack[index] >= arr[i]) {
                index--;
            }
            res[i] = (index == -1) ? -1 : stack[index];
            stack[++index] = arr[i];
        }
        return res;
    }
}
