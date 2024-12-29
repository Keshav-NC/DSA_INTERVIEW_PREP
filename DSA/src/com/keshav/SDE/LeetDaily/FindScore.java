package com.keshav.SDE.LeetDaily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindScore {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair (int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int compareTo(Pair that) {
            return this.val - that.val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 5, 2};
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append("->");
        sb.append(2);
        sb.append("->");
        sb.append(-34);
        System.out.println(sb.length());
        System.out.println(findScore(nums));
    }
    public static long findScore(int[] nums) {
        int n = nums.length;
        Queue<Pair> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            minHeap.offer(new Pair(nums[i], i));
        }
        // save index of cur and its adjacent
//        System.out.println(minHeap);
        HashSet<Integer> seen = new HashSet<>();
        long score = 0;
        while (!minHeap.isEmpty()) {
            int curIndex = minHeap.poll().index;
            if (!seen.contains(curIndex)) {
                seen.add(curIndex);
                score += nums[curIndex];
                if (curIndex - 1 >= 0) {
                    seen.add(curIndex - 1);
                }
                if (curIndex + 1 < n) {
                    seen.add(curIndex + 1);
                }
            }
        }
        return score;
    }
}
