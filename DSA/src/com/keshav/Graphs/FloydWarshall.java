package com.keshav.Graphs;

import javax.imageio.ImageTranscoder;
import java.util.List;

public class FloydWarshall {
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
    /*
        Note:
            1) To find the shortest path from every node to every other node
            2) Multi-source the shortest path algo
            2) It can detect negative cycle
            4) Easiest to code & understand
            5) Uses DP
     */
    private static int[][] floydWarshall(int[][] dist) {
//        dist[i][j] == -1 no path to infinity
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1) {
                    dist[i][j] = 1001; // check the constraints and assign acc.
                }
            }
        }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == 1001) {
                    dist[i][j] = -1; // check the constraints and assign acc.
                }
            }
        }
        return dist;
    }
}
