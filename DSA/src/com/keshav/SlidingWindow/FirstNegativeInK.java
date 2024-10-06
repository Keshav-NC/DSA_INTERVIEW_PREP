package com.keshav.SlidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInK {
    // Q -> first negative integer in every window size of k
    public static void main(String[] args) {
        int[] arr = {-8, -9, 10, 3, -13, -19, 20, 30};
        int k = 2;
        System.out.println(Arrays.toString(findFirstNegative(arr, k)));
    }

    private static int[] findFirstNegative(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length;
        // for first window
        for (int i = 0; i < k; i++) {
            // add only the negative number of size k for first window
            if (arr[i] < 0) {
                queue.offer(arr[i]);
            }
        }
        int[] res = new int[n-k+1];
        // add first negative number from queue, or if queue is empty, then add 0
        res[0] = (queue.isEmpty()) ? 0 : queue.peek();

        for (int i = 1; i < n-k+1; i++) {
            // removed number is negative, then pop from queue
            if (arr[i-1] < 0) {
                queue.poll();
            }
            // added number is negative, then insert into queue, if not negative don't insert
            if (arr[i+k-1] < 0) {
                queue.offer(arr[i+k-1]);
            }
            res[i] = (queue.isEmpty()) ? 0 : queue.peek();
        }
        return res;
    }
}
