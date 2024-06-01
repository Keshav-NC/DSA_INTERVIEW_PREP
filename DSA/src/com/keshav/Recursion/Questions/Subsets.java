package com.keshav.Recursion.Questions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subset(arr);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }

    static List<List<Integer>> subset (int[] arr) {
        // create new list of list --> we are inserting many list into list
        List<List<Integer>> outer = new ArrayList<>();
        // initially outer list is empty
        outer.add(new ArrayList<>());

        for (int num : arr) {
            int outerSize = outer.size();
            for (int i = 0; i < outerSize; i++) {
                // making copy of outer list for every index i
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }
}
