package com.keshav.Sorting;

import java.util.Arrays;

public class MergeSort {
    /*
    points:
        - Divide the array into two parts.
        - get both part sorted via recursion
        - merge the sorted paths
            pointer   |                |
            - arr1 = [3, 5, 9] arr2 = [4, 6, 8]
            - start checking from the very first indies
            - create new array of size 0f (arr1 + arr2)
            - check smaller number and place it in the new array and move the pointer to the next index
     */
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int m = left.length;
        int n = right.length;
        int[] newArr = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (left[i] < right[j]) {
                newArr[k] = left[i++];
            } else {
                newArr[k] = right[j++];
            }
            ++k;
        }
        while (i < m) {
            newArr[k++] = left[i++];
        }
        while (j < n) {
            newArr[k++] = right[j++];
        }
        return newArr;
    }
}
