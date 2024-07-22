package com.keshav.SDE.LeetDaily;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }
    static int removeElement(int[] nums, int val) {
        int[] freq = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            freq[nums[i]]++;
        }
        int index = 0;
        for (int j=0; j<freq.length; j++) {
            if (freq[j] != 0) {
                index += freq[j];
            }
        }
        return index - freq[val];
    }
}
