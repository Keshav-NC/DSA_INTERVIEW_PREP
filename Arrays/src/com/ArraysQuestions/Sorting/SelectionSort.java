package com.ArraysQuestions.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,2,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //find the maximum remaining item in the array and swap it with correct index
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, last);
//            int minIndex = getMinIndex(arr, last);
            swap(arr, maxIndex, last);

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
