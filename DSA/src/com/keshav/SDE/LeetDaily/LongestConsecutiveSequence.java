package com.keshav.SDE.LeetDaily;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(10);
        int n = list.size();
        double sum = 0.0;
        for (int l : list) {
            sum += l;
        }
        System.out.println(sum + ", " + sum / n);
//        System.out.println(longestConsecutiveSequence(nums));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int count = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (diff == 1){
                ++count;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max + 1;
    }
}
