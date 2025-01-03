package com.keshav.Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {
//        [[1], [0,2,4], [1,3], [2,4], [1,3]]
        List<Integer>[] adj = new List[5];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[1].add(0);
        adj[1].add(2);
        adj[1].add(4);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(2);
        adj[3].add(4);
        adj[4].add(1);
        adj[4].add(3);
        System.out.println(isCycle(adj));
    }

    private static boolean isCycle(List<Integer>[] adj) {
        int v = adj.length;
        boolean[] visited = new boolean[v];
        // bfs
//        for (int i = 0; i < v; i++) {
//            if (!visited[i] && checkIfCycleBFS(i, adj, visited)) {
//                return true;
//            }
//        }
        // dfs
        for (int i = 0; i < v; i++) {
            if (!visited[i] && checkIfCycleDFS(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    // UD
    private static boolean checkIfCycleDFS(int src, int parent, List<Integer>[] adj, boolean[] visited) {
        visited[src] = true;
        for (int neighbour : adj[src]) {
            if (neighbour == parent) continue;
            if (visited[neighbour]) return true;
            else {
                if (checkIfCycleDFS(neighbour, src, adj, visited)) return true;
            }
        }
        return false;
    }

    // UD
    private static boolean checkIfCycleBFS(int src, List<Integer>[] adj , boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, -1}); // -1 parent of start node
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int parent = queue.poll()[1];

            for (int neighbour : adj[node]) {
                if (neighbour == parent) continue; // skip
                if (visited[neighbour]) return true; // cycle exits
                else {
                    queue.offer(new int[] {neighbour, node});
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }

    // D - dfs
    public static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[src] = true;
        pathVisited[src] = true;

        for (int neighbour : adj.get(src)) {
            if (pathVisited[neighbour]) {
                return true;

            } else if (visited[neighbour]) {
                continue;
            } else {
                if (dfs(neighbour, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        pathVisited[src] = false;
        return false;
    }
}
