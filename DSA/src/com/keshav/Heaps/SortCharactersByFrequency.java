package com.keshav.Heaps;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.*;

class Characters implements Comparable<Characters> {
    char ch;
    int freq;

    Characters(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Characters that) {
        return that.freq - this.freq; // dec
    }

    @Override
    public String toString() {
        return "Character -> " + this.ch + " , Freq -> " + this.freq;
    }
}
public class SortCharactersByFrequency {
    public static void main(String[] args) {
//        frequencySort("tree");
        System.out.println(frequencySort("Aabb"));
    }
    public static String frequencySort(String s) {
        // using priority queue
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }
        PriorityQueue<Characters> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Characters c = new Characters(entry.getKey(), entry.getValue());
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        int n = queue.size();
        System.out.println(queue);
        while (n > 0) {
            Characters c = queue.poll();
            int freq = c.freq;
            for (int i = 0; i < freq; i++) {
                sb.append(c.ch);
            }
            n--;
        }
        return sb.toString();
    }
}
