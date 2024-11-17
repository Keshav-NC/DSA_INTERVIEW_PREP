package com.keshav.BinarySearching.BinarySearchOnAnswer;

public class MinimizedMaximumDistributionProducts {
    public static void main(String[] args) {
        int[] quantities = {15, 10, 10};
        int stores = 7;
        System.out.println(minimizeMaximum(quantities, stores));
    }

    private static int minimizeMaximum(int[] quantities, int stores) {
        int start = 1; // to avoid divide by zero error
        int end = Integer.MIN_VALUE; // to find max value in quantities
        for (int q : quantities) {
            end = Math.max(q, end);
        }
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isDistributionPossible(quantities, mid, stores)) {
                res = mid; // possible ans, minimize
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static boolean isDistributionPossible(int[] quantities, int products, int stores) {
        int storeCount = 0;
        for (int q : quantities) {
            storeCount += q / products;
            if (q % products != 0) {
                ++storeCount;
            }
            if (storeCount > stores) {
                return false;
            }
        }
        return true;
    }
}
