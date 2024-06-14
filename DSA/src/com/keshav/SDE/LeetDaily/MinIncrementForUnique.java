package com.keshav.SDE.LeetDaily;

public class MinIncrementForUnique {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 2, 7};
        System.out.println(minIncrementForUnique(nums));
    }


    // TC : O(n) + (n + m)
    // SC : O(n + m)
    static int minIncrementForUnique (int[] nums) {
        int maxEle = findMax(nums);

        int n = nums.length;
        // for counting the freq of each element
        int[] count = new int[maxEle + n];

        // find the freq
        for (int num : nums) {
            count[num]++;
        }

        // find the number of moves
        int moves = 0;
        for (int i=0;i<count.length;i++) {
            if (count[i] <= 1) {
                continue;
            }

            int extra = count[i] - 1;
            moves += extra;
            count[i+1] += extra;
            count[i] = 1; // sync
        }
        return moves;
    }

    // TC : O(n)
    private static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
