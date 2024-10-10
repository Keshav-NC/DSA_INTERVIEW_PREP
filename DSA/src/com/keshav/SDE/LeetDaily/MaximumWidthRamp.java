package com.keshav.SDE.LeetDaily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Ramp implements Comparable<Ramp> {
    int value;
    int index;

    public Ramp(int value, int index) {
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(Ramp that) {
        return this.value - that.value; // increasing
//        return that.value - this.value; // decreasing
    }

    @Override
    public String toString() {
        return ("(" + this.value + ", " + this.index + ")");
    }
}
public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[] arr = {9,8,1,0,1,9,4,0,4,1};
        int n = arr.length;
        int[] index = new int[arr.length];
        int[] rightMax = new int[n];

        // Fill rightMax array with the maximum values from the right
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        System.out.println(Arrays.toString(rightMax));
//        Arrays.fill(index, 0);
////        System.out.println(maximumWidth(arr));
//        maximumWidth(arr);
    }

    private static void maximumWidth(int[] arr) {
        int n = arr.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        int minIndex = n;
        int maxWidth = 0;

        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return arr[a] - arr[b];
            }
        });

        System.out.println(Arrays.toString(index));

//        ArrayList<Ramp> list = new ArrayList<>();

//        for (int i = 0; i < n; i++) {
//            Ramp obj = new Ramp(arr[i], i);
//            list.add(obj);
//        }
//        Collections.sort(list);
//

//
//        for (Ramp l : list) {
//            int index = l.index;
//            maxWidth = Math.max(maxWidth, index - minIndex);
//            minIndex = Math.min(minIndex, index);
//        }
//        System.out.println(list);
//        System.out.println(maxWidth);
////        return max;
    }
}
