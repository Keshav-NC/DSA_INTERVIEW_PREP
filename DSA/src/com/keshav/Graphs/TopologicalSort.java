package com.keshav.Graphs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int n = 4;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        // [[], [0], [0], [0]]
        adj[1].add(0);
        adj[2].add(0);
        adj[3].add(0);
        System.out.println(topologicalSort(adj));
    }

    /* Note : Topological sort : Linear ordering of vertices such that if there is an edge
       between u & v, such that u should appear before v [u -> v]
       If is only possible in DAG[Direct Acyclic Graph]
     */
    // Kahn's Algorithm -- BFS
    private static List<Integer> topologicalSort(List<Integer>[] adj) {
        int n = adj.length;
        int[] inDegree = new int[n];
        for (int u = 0; u < n; ++u) {
            for (int v : adj[u]) {
                ++inDegree[v];
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // insert all the nodes with value 0 into queue
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            // visit all neighbours of curNode
            for (int neighbour : adj[node]) {
                --inDegree[neighbour];
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (res.size() != n) {
            return new ArrayList<>();
        }
        return res;
    }

    private static List<Integer> topoSortDFS(List<Integer>[] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        if (stack.size() != n) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void dfs(int src, List<Integer>[] adj, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for (int neighbour : adj[src]) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.push(src);
    }
}
