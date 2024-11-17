package com.keshav.BinarySearching.BinarySearchOnAnswer;

public class MaximumCandies {
    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        long k = 3;
        System.out.println(maximumCandies(candies, k));
    }

    private static int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int candy : candies) {
            end = Math.max(candy, end);
        }

        if (k > end) {
            return 0;
        }
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAllocationPossible(candies, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isAllocationPossible(int[] candies, int maxCandies, long children) {
        int childCount = 0;
        for (int candy : candies) {
            childCount += (candy / maxCandies);
            if (childCount >= children) {
                return true;
            }
        }
        return false;
    }
}
