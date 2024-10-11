package com.keshav.Heaps.Questions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosest implements Comparable<KClosest> {
    int value;
    int diff;

    public KClosest (int value, int diff) {
        this.value = value;
        this.diff = diff;
    }

    @Override
    public int compareTo(KClosest that) {
        if (that.diff == this.diff) {
            return this.value - that.value;
        }
        return this.diff - that.diff; // desc
    }

    @Override
    public String toString() {
        return "\nValue : " + this.value + " , diff : " + this.diff;
    }
}
public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println(closest(arr, k, x));
    }

    private static List<Integer> closest(int[] arr, int k, int x) {
        PriorityQueue<KClosest> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            int diff = Math.abs(x - num);
            KClosest obj = new KClosest(num, diff);
            maxHeap.offer(obj);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        System.out.println(maxHeap);
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll().value);
        }
        System.out.println(ans);
        return new ArrayList<>();
    }
}
