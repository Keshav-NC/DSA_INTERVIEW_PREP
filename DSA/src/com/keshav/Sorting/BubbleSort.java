package com.keshav.Sorting;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {75,34,30};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort (int[] arr) {
    boolean swapped;
        //run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            // for each step , max item will come at last respective index
            swapped = false;
            for (int j = 1; j < arr.length - i ; j++) {
                // if current item is smaller than previous item, then swap
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //if you did not swap for a particular value of i, it means that the array is sorted
            if (!swapped) break;
        }
    }
}
