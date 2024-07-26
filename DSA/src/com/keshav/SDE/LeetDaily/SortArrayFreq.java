package com.keshav.SDE.LeetDaily;

import com.sun.source.tree.BreakTree;

import javax.xml.validation.SchemaFactoryConfigurationError;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayFreq {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(sortFreq(nums)));
    }

    private static int[] sortFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // custom comparator does'nt work on primitive data types, so convert nums to Integer data types
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (freq.get(a).equals(freq.get(b))) {
                    return b - a; // dec order of value
                }
            return freq.get(a) - freq.get(b);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        return nums;
    }
}
