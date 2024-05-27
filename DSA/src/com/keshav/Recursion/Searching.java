package com.keshav.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Searching {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 3, 9, 3, 5, 3};
        int target = 3;
//        System.out.println(search(nums, target));
//        helperAllIndex(nums, target, 0);
//        System.out.println(list);
//        System.out.println(helperAllIndexArrayList(nums, target, 0, new ArrayList<>()));
        System.out.println(helperAllIndexWOArrayListArgs(nums, target, 0));
    }

    static int search (int[] nums, int target) {
//        return helperBool (nums, target, 0) ;
//        return helperIndex(nums, target, 0) ;
        return helperLastIndex(nums, target, nums.length - 1);
    }

    // finding target element from the last index
    private static int helperLastIndex(int[] nums, int target, int index) {

        if (index == -1) {
            return -1;
        }

        if (nums[index] == target) {
            return index;
        }

        return helperLastIndex(nums, target, --index);
    }

    // return in the form of true or false --> from start index
    static boolean helperBool (int[] nums, int target, int index) {
        if (index == nums.length) {
            return false;
        }

        if (nums[index] == target) {
            return true;
        }
        return nums[index] != target && helperBool(nums, target, ++index);
    }

    // return index --> from start index
    static int helperIndex(int[] nums, int target, int index) {
        if (index == nums.length) {
            return -1;
        }

        if (nums[index] == target) {
            return index;
        }
        return helperIndex(nums, target, ++index);
    }


    // return list all index of the element --> from start index
    static ArrayList<Integer> list = new ArrayList<>();
    static void helperAllIndex (int[] nums, int target, int index) {

        if (index == nums.length) {
            return;
        }
        if (nums[index] == target) {
            list.add(index);
        }
        helperAllIndex(nums, target, ++index);
    }

    // instead of creating ArrayList outside the function, you can also use in the arguments of the function as shown below

    static ArrayList<Integer> helperAllIndexArrayList (int[] nums, int target, int index, ArrayList<Integer> list) {
        if (index == nums.length) {
            return list;
        }
        if (nums[index] == target ) {
            list.add(index);
        }
        return helperAllIndexArrayList(nums, target, ++index, list);
    }


    // returning ArrayList without passing ArrayList in the argument
    // it's not the optimised code
    // don's use this approach, use above approach
    static ArrayList<Integer> helperAllIndexWOArrayListArgs (int[] nums, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == nums.length) {
            return list;
        }

        if (nums[index] == target) {
            list.add(index);
        }
        /* we are using ArrayList within the body of the function, at each call new ArrayList will be created,
           so we are getting ans from below calls if that call has some value, and then add all it in list
           i.e, means after reaching last index, then each call will be returned to where it was called
            while returning we add values of each call only if that call has some value
        */
        ArrayList<Integer> ansFromBelowCalls = helperAllIndexWOArrayListArgs(nums, target, ++index);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
