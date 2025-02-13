package com.keshav.SDE.LeetDaily;

public class SpecialArray {
    public static void main(String[] args) {
        int[] nums = {4,3,1,6};
        System.out.println(isArraySpecial(nums));
    }

    private static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 1) || (nums[i] % 2 == 1 && nums[i + 1] % 2 == 0)) continue;
            return false;
        }
        return true;
    }
}
