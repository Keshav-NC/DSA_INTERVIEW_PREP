package com.keshav.SlidingWindow;

public class LongestSubArraySumK {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 10, 10};
        int k = 14;
        System.out.println(subArraySum(nums, k));
    }


    public static int subArraySum (int[] nums, int k) {
        int n = nums.length;

        // initially both the pointer will be pointing to same value
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxLength = 0;

        while (end < n) {
            sum += nums[end];
//            // for returning subarray
//            while (sum > k) { // subtract start value of the cur window and move / shrink the window
//                sum -= nums[start];
//                start++;
//            }
            // for returning length of the longest subarray
            if (sum > k) {
                sum -= nums[start];
                start++;
            }
            if (sum <= k) { // calculate the window length
                // store the maximum window length
                maxLength = Math.max(maxLength, end - start + 1); //window size end-start+1 --> 3-1+1=3
            }
            end++; // add the next value into the window
        }
        return maxLength;
    }

}
