package com.keshav.Stacks;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;
import java.util.Stack;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        int[] stack1 = {
                4, 2, 4, 6, 1
        };
        int[] stack2 = {
                2, 1, 8, 5
        };
        System.out.println(gameOfTwoStacks(stack1,stack2, 10, 0, 0) - 1);
    }

    public static int gameOfTwoStacks(int[] stack1, int[] stack2, int maxSum, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        if (stack1.length == 0 || stack2.length == 0) {
            return count;
        }

        return Math.max(gameOfTwoStacks(Arrays.copyOfRange(stack1, 1, stack1.length), stack2, maxSum, sum + stack1[0], count + 1 ),
                gameOfTwoStacks(stack1, Arrays.copyOfRange(stack2, 1, stack2.length), maxSum, sum + stack2[0], count + 1));
    }
}
