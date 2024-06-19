package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinNumOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay, m , k));
    }

    static int[] findRange (int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        return new int[] {min, max};
    }

    static int minDays (int[] bloomDay, int m, int k) {
        int[] range = findRange(bloomDay);

        int start = range[0];
        int end = range[1];
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(mid, bloomDay, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int midDay, int[] bloomDay, int m, int k) {
        int total = 0;
        int count = 0;

        for (int i=0;i<bloomDay.length;i++) {
            if (bloomDay[i] <= midDay) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                total++;
                count = 0;
            }

            if (total >= m) {
                return true;
            }
        }
        return false;
    }
}
