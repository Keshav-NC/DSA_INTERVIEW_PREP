package com.keshav.BinarySearching.BinarySearchOnAnswer;

import java.util.ArrayList;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 8, 8, 10, 10, 12};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.set(2, 3);
        System.out.println(list.get(2-1));
        System.out.println(list);
        int target = 9;
        System.out.println(lowerBound(nums, target));
    }
    // very important algorithm

    // Lower Bound = smaller index such that arr[index] >= target (or) x
    private static int lowerBound(int[] nums, int target) {
        // hypothetical ans
        int ans = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // maybe an answer, go check the smaller index
            if (nums[mid] >= target) {
                ans = mid;
                // obviously my answer will be in left side, eliminate right side search
                end = mid - 1;
            } else {
                // eliminate left side search and find the answer on the right side
                start = mid + 1;
            }
        }
        return ans;
    }
}
