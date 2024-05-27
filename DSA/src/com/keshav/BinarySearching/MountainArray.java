package com.keshav.BinarySearching;

public class MountainArray {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 5, 6, 4, 2, 1};
//        System.out.println(peakIndexInMountainArray(nums));
        int[] nums = {4,3,2,-1};
        System.out.println(minimum(nums));

    }

    static int minimum (int[] row) {
        int start = 0;
        int end = row.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && row[mid] > row[mid+1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
    static int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end-start) / 2;
            if (nums[mid] > nums[mid+1]){
                //you are in dec part of the array
                //this may be the ans, but check lhs
                //this is why end != mid-1
                end = mid;
            }
            else {
                //you are in asc part of the array
                start = mid + 1;//coz wkt that mid+1 > mid-element, hence we are ignoring mid
            }
        }
        // if start == end, then the value at this index is the maximum value
        // if we get only the single from tha above checks or above conditions than that value will be the possible maximum value;
        return start; // here we can either return start or end coz both start and end pointing to the same element
    }

}
