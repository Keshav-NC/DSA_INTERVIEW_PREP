package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianFinder {
    List<Integer> list;
    int n;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    public void addNum(int num) {
        list.add(num);
        n = list.size();
    }
    public double findMedian() {
        if (n % 2 == 0) { // even
            double sum = 0.0;
            for (int l : list) {
                sum += l;
            }
            return sum/n;
        }
        // odd
        Collections.sort(list);
        int mid = n/2;
        return list.get(mid);
    }
}
public class FindMedian {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        // MedianFinder","addNum","findMedian","addNum",
        // "findMedian","addNum","findMedian","addNum","
        // findMedian","addNum","findMedian","addNum","findMedian"
        obj.addNum(6);
        System.out.print(obj.findMedian() + ", ");
        obj.addNum(10);;
        System.out.print(obj.findMedian() + ", ");
        obj.addNum(2);;
        System.out.print(obj.findMedian() + ", ");
        obj.addNum(6);
        System.out.print(obj.findMedian() + ", ");
        obj.addNum(5);
        System.out.print(obj.findMedian() + ", ");
        obj.addNum(0);
        System.out.print(obj.findMedian() + ", ");
    }
}
