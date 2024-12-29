package com.keshav.Graphs;

import javax.lang.model.type.MirroredTypeException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {{2,3,1}, {0}, {0,4}, {0}, {2}};
        Graph g = new Graph(v);

        List<List<Integer>> adjList = g.createAdjList(edges, false);
        g.printList();
        boolean[] visited = new boolean[v];
        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            if (!(visited[i])) {
//                dfs(i, visited, adjList, res);
//            }
//        }
//        System.out.println("DFS : " + res);
        System.out.println("BFS : " + bfs(0, v, visited, adjList));
    }
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adjList, List<Integer> res) {
        // mark current node as visited
        visited[node] = true;
        // store the visited value
        res.add(node);
        // call dfs for its neighbour
        for (int neighbour : adjList.get(node)) {
            if (!(visited[neighbour])) {
                dfs(neighbour, visited, adjList, res);
            }
        }
    }

    public static List<Integer> bfs(int source, int v, boolean[] visited, List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // add to res
            res.add(node);
            for (int neighbour : adjList.get(node)) {
                if (!(visited[neighbour])) {
                    // mark cur node as visited
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    }
}
