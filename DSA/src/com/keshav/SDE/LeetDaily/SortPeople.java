package com.keshav.SDE.LeetDaily;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/sort-the-people/?envType=daily-question&envId=2024-07-22
public class SortPeople {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sort(names, heights)));
    }

    static String[] sort (String[] names, int[] heights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < heights.length; i++) {
            if (!map.containsKey(heights[i])) {
                map.put(heights[i], i);
            }
        }
        Arrays.sort(heights);
        for (int i = heights.length-1; i >= 0; i--) {
            if (map.containsKey(heights[i])) {
                ans[heights.length-1-i] = names[map.get(heights[i])];
            }
        }
        return ans;
    }
}
