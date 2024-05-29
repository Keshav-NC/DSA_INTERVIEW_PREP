package com.keshav.Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8, 3, 4, 2, 5, 6};
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    static int[] mergeSort (int[] nums) {
        // if array length reaches index 1, just return the array
        if (nums.length == 1) {
            return nums;
        }
        // dividing array into two parts
        int mid = nums.length / 2;

        // check the left and right recursive call and store it in the respective array
        // pass the copy of the original array
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge (left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        // create an of new array of size of both first and second array
        int[] mix = new int[first.length + second.length];

        // for first array
        int i = 0;
        // for second array
        int j = 0;
        // for mix array
        int k = 0;

        // loop until any of the array (first or second) runs arrayOutOfBoundError
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            // after inserting value in mix array, increment the k value
            k++;
        }


        // there may be some cases, one of the array may contain more values than the other array --> means one of the array is not complete
        // just fill remaining values at the last of the mix array

        // only one loop will run, either first array or second array based on the above condition
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
