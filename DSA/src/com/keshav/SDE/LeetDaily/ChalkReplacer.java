package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class ChalkReplacer {
    public static void main(String[] args) {
        int[] chalk = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 10;

        System.out.println(prefixSumChalkReplacer (chalk, k));
    }

    private static int chalkReplacer(int[] chalk, int k) {
        long sum = Arrays.stream(chalk).asLongStream().sum();
        k = (int) (k % sum);
        if (k == 0) return 0;

        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) return i;

        }
        throw new IllegalArgumentException();
    }
    // BS approach
    private static int prefixSumChalkReplacer (int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        // calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + chalk[i];
        }
        // calculate the remaining chalks
        long sumChalk = prefixSum[prefixSum.length - 1];
        int remainingChalk = (int)(k % sumChalk);

        int start = 0;
        int end = n - 1;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (prefixSum[mid] == remainingChalk) {
                return mid + 1;
            } else if (prefixSum[mid] < remainingChalk){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
