package com.keshav.Sorting;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] newArr = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                newArr[k] = arr[i++];
            } else {
                newArr[k] = arr[j++];
            }
            ++k;
        }

        while (i < mid) {
            newArr[k++] = arr[i++];
        }

        while (j < end) {
            newArr[k++] = arr[j++];
        }

        for (int l = 0; l < newArr.length; ++l) {
            arr[start + l] = newArr[l];
        }
    }
}
