package com.ArraysQuestions.Sorting;

import static com.ArraysQuestions.Sorting.SelectionSort.swap;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(sort1N(nums));
//        System.out.println(sort0N(nums));
    }
//    range from 1 to N
    static int sort1N (int[] nums) {
        int i=0;
        while (i < nums.length) {
            // 0  1  2  3  4
            //[1, 3, 4, 2, 2]
            // if the ith element is equal to the next element i.e i+1, then swap those elements,
            // or else just move to the next index i.e i++;
            // i=0 --> nums[0] != 0+1 --> 1 != 1 --> false just move to next element --> i++
            if (nums[i] < 0 || nums[i] < nums.length) {
                if (nums[i] != i) {
                    if (nums[i] != nums[nums[i]]) {
                        swap(nums, i, nums[i]);
                    } else {
                        return nums[i];
                    }
                } else {
                    i++;
                }
            } else {
                if (nums[i] != i + 1) {
                    if (nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
                    else return nums[i];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
//    range from 0 to N
    static int sort0N (int[] nums) {
        int i=0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] != i) {
                if (nums[i] != nums[correctIndex]) {
                    swap(nums, i, correctIndex);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
