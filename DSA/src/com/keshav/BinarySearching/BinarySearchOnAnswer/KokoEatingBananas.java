package com.keshav.BinarySearching.BinarySearchOnAnswer;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        // find the largest value in the piles
        for (int banana : piles) {
            end = Math.max(banana, end);
        }

        // apply binary search on the possible values of k (1, max(piles))
        int k = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isEatingSpeedPossible(piles, mid, h)) {
                k = mid; // possible ans, minimize it
                end = mid - 1;
            } else {
                start = end - 1;
            }
        }
        return k;
    }

    private static boolean isEatingSpeedPossible(int[] piles, int eatingSpeed, int h) {
        int hoursSpent = 0;
        for (int banana : piles) {
            hoursSpent += (int) Math.ceil((double) banana / eatingSpeed);
//            if (banana % eatingSpeed != 0) {
//                ++hoursSpent;
//            }
            if (hoursSpent > h) {
                return false;
            }
        }
        return true;
    }
}
