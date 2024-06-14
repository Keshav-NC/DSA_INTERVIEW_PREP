package com.keshav.SDE.LeetDaily;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = {24,5,64,53,26,38};
        int k = 54;
        System.out.println(maximumProduct(nums, k));
    }

    static int findMin(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        return min;
    }

    private static int maximumProduct(int[] nums, int k) {
        for (int i=0;i<k;i++) {
            int minIndex = findMin(nums);
            nums[minIndex]++;
        }
        long product = 1;
        for (int num : nums) {
            product *= num;
            product %= 1000000007;
        }
        return (int)product;
    }
}
