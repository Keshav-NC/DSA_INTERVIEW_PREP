package com.keshav.Recursion.Questions;

import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Subsets {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
        int[] arr = {1,1,2,2};
        System.out.println(subsetsWithDuplicates(arr));
    }

//    [[],[1],[1,1],[1,1,2],[1,1,2,2],[1,2],[1,2,2],[2],[2,2]]...

    // without duplicates
    static List<List<Integer>> subset (int[] arr) {
        // create new list of list --> we are inserting many list into list
        List<List<Integer>> outer = new ArrayList<>();
        // initially outer list is empty
        outer.add(new ArrayList<>());
        // for every num in the array, create a new list (internal) of size of outer list and append to the outer list
        // means --> for every num, the number of times the outer list size --> is that many list will be created
        for (int num : arr) {
            int outerSize = outer.size();

            // making copy of outer list for every index i th list --> in that copy everywhere we are adding the 'num'.

            /* eg: outer list -- > [] [1] [2] [1, 2], make copy of this list in internal,
               internal list --> [] [1] [2] [1, 2] --> in that everywhere we are adding the 'num'
               after appending i.e, [3] [1, 3] [2, 3] [1, 2, 3]
            */

            // outer --> [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
            //     i -->  0    1    2      3     4      5       6        7

            for (int i = 0; i < outerSize; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }


    static List<List<Integer>> subsetsWithDuplicates (int[] arr) {
        /*
            NOTE:
                - when we find a duplicate element, then add it in the newly created subset of the previous step
                - above point is valid only if the duplicate element together --> so sort the array first
         */

        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0;i < arr.length;i++) {
            // if current and previous element are same, then start = end + 1;
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            // if not
            end = outer.size() - 1;

            int outerSize = outer.size();

            for (int j = start; j < outerSize; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}
