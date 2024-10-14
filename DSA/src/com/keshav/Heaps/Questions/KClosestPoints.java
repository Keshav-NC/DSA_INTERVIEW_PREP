package com.keshav.Heaps.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int dist;
    int index;

    public Point (int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Point that) {
        return that.dist - this.dist;
    }

    @Override
    public String toString() {
        return "Point{" +
                "dist=" + dist +
                ", index=" + index +
                '}';
    }
}

public class KClosestPoints {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>();

        int i = 0;
        for (int[] point : points) {
            int dist = calculate(point[0], point[1]);
            Point obj = new Point(dist, i++);
            maxHeap.offer(obj);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        System.out.println(maxHeap);
        int[][] ans = new int[k][2];

        for (int j = 0; j < k; j++) {
            int[] point = points[maxHeap.poll().index];
            ans[j] = point;
        }
        return ans;
    }
    private static int calculate (int x, int y) {
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
