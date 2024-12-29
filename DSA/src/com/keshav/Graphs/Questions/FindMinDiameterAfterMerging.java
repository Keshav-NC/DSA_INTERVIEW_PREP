package com.keshav.Graphs.Questions;

import com.keshav.Graphs.Graph;

import java.sql.ClientInfoStatus;
import java.util.*;

public class FindMinDiameterAfterMerging {
    public static void main(String[] args) {
        int nodes = 8;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        Graph g = new Graph(nodes);
        List<List<Integer>> adj = g.createAdjList(edges1, false);
        System.out.println(adj.size());
//        List<HashSet<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < nodes; ++i) {
//            adj.add(new HashSet<>());
//        }
//        createAdjList(edges1, adj);
//        for (HashSet<Integer> list : adj) {
//            System.out.println(list);
//        }
        System.out.println(bfs(adj,nodes));
    }
    public static void createAdjList(int[][] edges, List<HashSet<Integer>> adj) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
    }
    public static int bfs(List<List<Integer>> adj, int nodes) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes];
        queue.offer(0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = true;
                for (int neighbour : adj.get(node)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            ++level;
        }
        return level + 1;
    }
}
