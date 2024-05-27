package com.keshav.BinarySearching;

public class BSOrderAgnostic {
    public static void main(String[] args) {
//        int[] nums = {100, 50, 50, 30, 10, 0, -20, -40};
        int[] nums = {-20, -16, -7, 0, 20, 50, 70, 88, 999};
        int target = 999;
        int ans = orderAgnosticBS(nums, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS (int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (isAsc) {
                if(target < arr[mid]) end = mid - 1;
                else if (target > arr[mid]) start = mid + 1;
            } else {
                if (target > arr[mid]) start = mid + 1;
                else if (target < arr[mid]) end = mid - 1;
            }
        }
        return -1;
    }
}
