package com.ArraysQuestions.BinarySearching;

public class BSInfiniteNumbers {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
        int target = 50;
        int ans = findAns(nums, target);
        System.out.println(ans);
    }

    static int findAns (int[] nums, int target) {
        //first find the range
        //first start with box of size 2
        int start = 0;
        int end = 1;

        //condition for target to lie in range
        while (target > nums[end]) {
            int temp = end + 1; // this is my new start --> using temp coz we need previous start value before updating end value

            //double the value of box
            //end = previous end + sizeOfBox * 2;
            //[10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140]
            // [0   1] [2   3   4   5] [6   7   8   9    10   11   12   13] <-- index
            //   box1        box2                  box3
            // initial start = 0, end = 1 -- first box size
            // temp = end + 1 = 1 + 1 = 2
            // end = 1 + (1 - 0 + 1) * 2 = 5 --> second box size --> start = temp --> start = 2;
            // temp = end + 1 = 5 + 1 = 6
            // end = 5 + (5 - 2 + 1) * 2 = 13 -- third box size --> start = temp -- start = 6
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return infiniteBS(nums, target, start, end);
    }
    static int infiniteBS(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (target > nums[mid]) start = mid + 1;
            else if (target < nums[mid]) end = mid - 1;
            else return mid;
        }
        return -1;

    }

}
