package com.ArraysQuestions.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.ArraysQuestions.Sorting.SelectionSort.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    static void insertionSort (int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
