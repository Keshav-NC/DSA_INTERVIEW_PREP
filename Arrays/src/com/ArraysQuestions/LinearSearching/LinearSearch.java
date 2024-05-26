package com.ArraysQuestions.LinearSearching;

public class LinearSearch {
    public static void main(String[] args) {
//        int[] nums = {};
//        int target = 444;
//        int ans = linearSearchInt(nums, target);
//        System.out.println(ans);
        String name = "keshav";
        char target = 'v';
        boolean ans = linearSearchStr(name, target);
        System.out.println(ans);

    }

    static boolean linearSearchStr (String str, char target) {
        //this checks if the string is empty
        if (str.isEmpty()) {
            return false;
        }

        //run for loop
        for (char ch : str.toCharArray()) { //this line using forEach loop, in order to use forEach loop the elements must be in array form,
                                            //so here toCharArray converts string into array
            if (ch == target) {
                return true;
            }
        }


//        for (int i = 0; i < str.length(); i++) {
//            if (target == str.charAt(i)) {
//                return true;
//            }
//        }

        //this line checks if the target element not found, if not return false

        return false;
    }

    static int linearSearchInt (int[] arr, int target) {
        //Base Condition
        //if array is empty return -1
        if (arr.length == 0) {
            return -1;
        }

        //check the target element using for loop
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element == target) return i;
        }

        //this line checking if the target element is not found
        //returns -1
        return -1;
    }
}
