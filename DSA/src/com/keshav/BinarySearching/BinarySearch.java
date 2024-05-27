package com.keshav.BinarySearching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-10, -7, -2, 0, 5, 67, 78, 80, 100, 111};
        int target = 67;
        int ans = binarySearch(nums, target);
        System.out.println(ans);

    }

    /*
    Ascending
    mid = start + (end - start) / 2;
    if (target > arr[mid]) end = mid + 1;
    else if (target < arr[mid]) end = mid - 1;
    else return mid;
     */
    /*
    Descending
    mid = start + (end - start) / 2;
    if (target > arr[mid]) end = mid - 1;
    else if (target < arr[mid]) end = mid + 1;
    else return mid;
     */

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
//            int mid = (start + end) / 2; // if size is larger than it will exceed more than int range
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1; // if target value is lesser than mid value
            } else if (target > arr[mid]) {
                start = mid + 1; // if target value is greater than mid value
            } else {
                return  mid; // if target element is mid value
            }
        }
        // if the target element not found
    return  -1;
    }
}
