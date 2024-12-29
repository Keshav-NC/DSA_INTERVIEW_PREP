package com.keshav.Graphs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(delay(times, n, k));
    }

    private static int delay(int[][] times, int n, int k) {
        List<int[]>[] adj = new List[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj[u].add(new int[] {v, w});
        }
        return dijsktra(n, k, adj);
    }

    private static int dijsktra(int n, int src, List<int[]>[] adj) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[src] = 0;
        minHeap.offer(new int[] {src, 0});

        while (!minHeap.isEmpty()) {
            int u = minHeap.peek()[0];
            int d = minHeap.poll()[1];
            if (d > dist[u]) continue;

            for (int[] neighbour : adj[u]) {
                int v = neighbour[0];
                int w = neighbour[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    minHeap.offer(new int[]{v, dist[v]});
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        int ans = Arrays.stream(dist).max().getAsInt();
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
