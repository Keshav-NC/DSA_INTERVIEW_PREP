package com.keshav.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 8, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //find the maximum remaining item in the array and swap it with correct index
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, last);
//            int minIndex = getMinIndex(arr, last);
            if (last != maxIndex) {
                swap(arr, maxIndex, last);
            }
        }
    }

    static int getMaxIndex (int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max]) max = i;
        }
        return max;
    }

    static int getMinIndex (int[] arr, int end) {
        int min = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] < arr[min]) min = i;
        }
        return min;
    }

    static void swap (int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
