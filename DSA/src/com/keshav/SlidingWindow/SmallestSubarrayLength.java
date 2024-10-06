package com.keshav.SlidingWindow;

public class SmallestSubarrayLength {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 99, 101};
        int x = 51;
        System.out.println(smallestLenght(arr, x));
    }

    private static int smallestLenght(int[] arr, int x) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        int start = 0;
        int end = 0;

        while (end < arr.length) {
            sum += arr[end];
            // expansion
            if (sum > x) {
                int len = end - start + 1;
                ans = Math.min(ans, len);

                // shrinking
                while (start < end && sum > x) {
                    sum -= arr[start];
                    ++start;
                    if (sum > x) {
                        len = end - start + 1;
                        ans = Math.min(ans, len);
                    }
                }
            }
            ++end;
        }
        return ans;
    }
}
