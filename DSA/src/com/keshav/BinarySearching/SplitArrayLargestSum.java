package com.keshav.BinarySearching;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArrayLargestSum(nums, k));
    }

    /*
        eg ---> [7, 2, 5, 10, 8] k = 2
        we can split into four ways
        1) [7] = 7, [2, 5, 10, 8] = 25, max = 25
        2) [7, 2] = 9, [5, 10, 8] = 23, max = 23
        3) [7, 2, 5] = 14, [10, 8] = 218, max = 18
        4) [7, 2, 5, 10] = 24, [8] = 8, max = 24

        so we have to return minimized maximum sum of split array
        ans = 18
     */

    /*
        - min number of partitions can be = 1
        - max number of partitions can be = n
     */

    /*
        case 1: min ans = largest value in the array --> arr = [7, 2, 5, 10, 8] --> [7] [2] [5] [10] [8] --> min = 10
        case 2: max ans --> sum of the entire array --> max = 32

        lb   ub
        [10, 32] --> now we can apply bs
        start = 10
        end = 32
        we are trying to find the potential answer that we can get
        mid = 10 + 32 / 2 = 21 --> here 21 might be the possible answer,
        try to see if we can split the array with the 21 as the max sum


     */

    static int splitArrayLargestSum (int[] nums, int k) {
        int start = 0;
        int end = 0;

        // find the max value in the array, and sum of all the values in the array
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        // now we got lower bound and upper bound

        // apply bs

        while (start < end) {
            // try for the middle as the potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces we can divide this in with this max sum
            int sum = 0;
            int pieces = 1; // min split

            for (int num : nums) {
                if (sum + num > mid) {
                    // you can not this in this subArray, make new one
                    // say you add this num in new subArray, then sum = num
                    sum = num;
                    pieces++; // coz we created new subArray
                } else {
                    sum += num;
                }
            }
            if (pieces <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // start == end
    }
}
