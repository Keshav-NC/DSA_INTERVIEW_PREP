package com.keshav.Graphs;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    /*
        Note:
            1) Single source shortest path
            2) Can detect negative cycle, but fails to give correct ans
            3) Works on directed graph
     */
    /*
        **RELAXATION** :
                * process of updating shortest path from source to other vertex.
                * distance array is updated, if a shortest path is found.
        Steps:
            1) for a graph of n nodes, do n - 1 relaxation.
            2) the (n - 1)th relaxation gives the shortest path.
            3) if the nth relaxation further reduces the SP, then the graph as neg cycle.
     */
    private static int[] bellmanFord(int n, List<List<Integer>> edges, int src) {
        int[][] ed = new int[5][5];
        int[] dist = new int[n];
        Arrays.fill(dist, (int)10e8);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isChanged = false;
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
            if (!isChanged) { // cur relation is not changing any dist then no need to check further!
                break;
            }
        }
        return dist;
    }
}
