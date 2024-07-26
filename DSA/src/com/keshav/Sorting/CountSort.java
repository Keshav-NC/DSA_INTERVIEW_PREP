package com.keshav.Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
//        countSortArray(nums);
        countSortHash(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void countSortHash(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        // to find max value in the array
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            // if num is occurring first time, then its freq is 'defaultValue i.e, 0' and increase it by 1,
            // if num is already in the map, then its freq is 'that num itself' and increase it by 1
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = countMap.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                nums[index++] = i;
            }
        }
    }

    private static void countSortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        // find the max value in the nums, and create an array of size max + 1
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // create countArray of size max + 1;
        // here index is the value of nums
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
    }
}
