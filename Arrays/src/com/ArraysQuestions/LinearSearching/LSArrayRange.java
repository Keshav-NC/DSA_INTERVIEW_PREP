package com.ArraysQuestions.LinearSearching;

import java.util.Scanner;

public class LSArrayRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1, 5, 7, 9, 30, 67, -34, -88};
        System.out.print("Enter the element to be searched: ");
        int target = in.nextInt();
        System.out.print("Enter the range (start and end):  ");
        int start = in.nextInt();
        int end = in.nextInt();
        boolean ans = arrayRange(arr,target, start, end);
        System.out.println(ans);
    }

    static boolean arrayRange(int[] arr,int target, int start, int end) {
        //this line checks if the arr is empty or not
        if (arr.length == 0) {
            return false;
        }

        //runs for loop with in the specified range
        for (int i = start; i <= end; i++) {
            int element = arr[i];
            if (element == target) return true;
        }

        //this line checks target element not found, returns false
        return false;
    }
}
