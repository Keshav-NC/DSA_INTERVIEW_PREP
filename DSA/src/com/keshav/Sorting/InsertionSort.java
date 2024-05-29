package com.keshav.Sorting;

import java.util.Arrays;

import static com.keshav.Sorting.SelectionSort.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    static void insertionSort (int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            for (int j = i+1; j > 0 ; j--) {
                // check if the element at current index is lesser than the previous element,
                // if true than swap it with the that element
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
