package com.keshav.BinarySearching.BinarySearchOnAnswer;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {10, 1, 2, 7, 5};
        int cows = 3;
        System.out.println(aggressiveCows(stalls, cows));
    }

    private static int aggressiveCows(int[] stalls, int cows) {
        int n = stalls.length;
        if (n < cows) {
            return -1;
        }
        Arrays.sort(stalls);
        int start = 1; // as per constraints
        int end = stalls[n-1] - stalls[0]; // maximum distance between two cows

        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // if allocation is possible, increase the distance
            if (isAllocationPossible(stalls, mid, cows)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private static boolean isAllocationPossible(int[] stalls, int minDistance, int cows) {
        int cowsPlaced = 1;
        int prevCowPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            // check minimum distance is maintained and update the prev cow distance as new distance
            if (stalls[i] - prevCowPosition >= minDistance) {
                ++cowsPlaced;
                prevCowPosition = stalls[i];
            }
            if (cowsPlaced >= cows) {
                return true;
            }
        }
        return false;
    }

}
