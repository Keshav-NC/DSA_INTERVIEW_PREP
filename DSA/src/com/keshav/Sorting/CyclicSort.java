package com.keshav.Sorting;

import com.keshav.Stacks.Questions.PreviousSmallerElement;

import java.util.Arrays;
import java.util.HashMap;

import static com.keshav.Sorting.SelectionSort.swap;
//NOTE : use cyclic sort only if we have range 1 to N, must be in continuous
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
//        int[] arr = {3,4,-1,1};

//        int[] arr = {3, 0, 1};
//        int ans = cycle(arr);
        cyclicSort(arr);
//        System.out.println(ans);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort (int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i]-1;
            if (arr[i] != arr[correctIndex]) swap (arr, i, correctIndex);
            else i++;
        }
//        for (int j=0;j<arr.length;j++) {
//            if (arr[j] != j+1 ) {
//                return j+1;
//            }
//        }
//        return -1;
    }

    static int cycle (int[] nums) {
        int i=0;
        //program of finding missing number in the given array
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                swap (nums, i, correctIndex);
            } else  {
                i++;
            }
        }
        //Search for the missing elements in the sorted array
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) return j;
        }
        return nums.length;
    }
}
