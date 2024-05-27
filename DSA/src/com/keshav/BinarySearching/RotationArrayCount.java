package com.keshav.BinarySearching;

public class RotationArrayCount {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(rotatedArrayCount(nums));
    }

    static int rotatedArrayCount (int[] nums) {
        //return no of times the array rotated
        return findPivot(nums) + 1;
    }

    //this will not work for duplicate values
    static int findPivot (int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start <= end) {
            int mid = start+(end-start)/2;

            //4 case over here
            if (mid < end && nums[mid] > nums[mid+1]) return mid;
            if (mid > start && nums[mid] < nums[mid-1]) return mid-1;
            if (nums[mid] <= nums[start]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    //this will work for duplicate values
    static int findPivotDuplicate (int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start+(end-start)/2;


            if (mid < end && nums[mid] > nums[mid+1]) return mid;
            if (mid > start && nums[mid] < nums[mid-1]) return mid-1;

//            if the elements at start, mid and end are same, then ignore duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
//                skip the duplicates --> start++ and end--
//                NOTE : what if these start and end element were pivot??
//                check if the start is pivot

                if (start < mid && nums[start] > nums[start+1]) return start;
                start++;

                //check if the end is pivot
                if (mid < end && nums[end] < nums[end-1]) return end-1;
                end--;
                if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}
