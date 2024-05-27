package com.keshav.BinarySearching;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,1,3,5};
        System.out.println(findMinPivotDuplicate(nums));
//        int target = 1;
//        System.out.println(search(nums, target));
    }

    static int search (int[] nums, int target) {
        int pivot = findPivot(nums);
//        int pivot = findPivotDuplicate(nums);
        if (pivot == -1) return binarySearch (nums, target, 0, nums.length-1);
        if (nums[pivot] == target) return pivot;
        if (target >= nums[0]) return binarySearch(nums, target, 0, pivot-1);
        else return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    static int binarySearch (int[] nums, int target, int start, int end) {
        while (start <= end) {
//            int mid = (start + end) / 2; // if size is larger than it will exceed more than int range
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1; // if target value is lesser than mid value
            } else if (target > nums[mid]) {
                start = mid + 1; // if target value is greater than mid value
            } else {
                return  mid; // if target element is mid value
            }
        }
        // if the target element not found
        return  -1;
    }
    //this will not work for duplicate values
    static int findPivot (int[] nums) {
        int start = 0;
        int end = nums.length-1;

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
            }
            //left is sorted, so pivot should be in right
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) start = mid+1;
            else end = mid-1;

        }
        return -1;
    }

    static int findMinPivotDuplicate (int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start+(end-start)/2;


            if (mid < end && nums[mid] > nums[mid+1]) return mid+1;
            if (mid > start && nums[mid] < nums[mid-1]) return mid;

//            if the elements at start, mid and end are same, then ignore duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {

//                skip the duplicates --> start++ and end--
//                NOTE : what if these start and end element were pivot??
//                check if the start is pivot

                if (start < mid && nums[start] > nums[start+1]) return start+1;
                start++;

                //check if the end is pivot
                if (mid < end && nums[end] < nums[end-1]) return end;
                end--;
            }
            //left is sorted, so pivot should be in right
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) start = mid+1;
            else  end = mid-1;

        }
        return -1;
    }

}
