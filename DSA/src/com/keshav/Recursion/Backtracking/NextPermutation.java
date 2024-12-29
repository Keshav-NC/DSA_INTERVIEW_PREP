package com.keshav.Recursion.Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums= {3, 2, 1};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    private static int[] nextPermutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int index = ans.indexOf(list);
        int ind = 0;
        if (index == ans.size() - 1) {
            for (int el : ans.getFirst()) {
                nums[ind++] = el;
            }
        } else {
            for (int el : ans.get(index + 1)) {
                nums[ind++] = el;
            }
        }
        return nums;
    }

    private static void helper(int[] nums, int start, List<List<Integer>> ans) {
        if (start == nums.length) {
            List<Integer> subList = new ArrayList<>();
            for (int num : nums) {
                subList.add(num);
            }
            ans.add(subList);
            return;
        }
        for (int i = nums.length - 1; i >= start; --i) {
            swap(nums, start, i);
            helper(nums, start + 1, ans);
            swap(nums, start, i);
        }
    }
    public static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
