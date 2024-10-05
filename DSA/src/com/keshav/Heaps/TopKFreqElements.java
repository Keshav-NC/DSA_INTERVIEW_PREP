package com.keshav.Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Number implements Comparable<Number> {
    int element;
    int freq;
    Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    @Override
    public int compareTo(Number that) {
        return that.freq - this.freq; // dec
    }
}

public class TopKFreqElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // find the freq of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // insert into pq
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().element;
        }
        return res;
    }
}
