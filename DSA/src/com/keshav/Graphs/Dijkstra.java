package com.keshav.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    class iPair {
        int first;
        int second;
        public iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
    }
    private static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int n = adj.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            dist.add(Integer.MAX_VALUE); // Initialize distances as infinity
        }
        dist.set(src, 0); // Distance to source is 0
        minHeap.offer(new int[] {src, 0});
        while (!minHeap.isEmpty()) {
            int u = minHeap.peek()[0]; // Current node
            int d = minHeap.poll()[1]; // Distance to current node
            if (d > dist.get(u)) continue; // Ignore outdated entries

            for (iPair neighbour : adj.get(u)) {
                int v = neighbour.first; // Neighbor node
                int w = neighbour.second; // Edge weight
                // relaxation
                if (dist.get(u) + w < dist.get(v)) {
                    dist.set(v, dist.get(u) + w); // Update distance
                    minHeap.offer(new int[] {v, dist.get(v)}); // Update distance
                }
            }
        }
        return dist;
    }
}
