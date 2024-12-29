package com.keshav.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    int[][] adjMatrix;
    List<List<Integer>> adjList;
    List<List<int[]>> adjListW;
    int n;
    public Graph(int nodes) {
        n = nodes;
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListW = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjListW.add(new ArrayList<>());
        }
    }
    public void createAdjMat(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isDirected) {
                adjMatrix[u][v] = 1;
            } else {
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void createAdjMatWeights(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected) {
                adjMatrix[u][v] = w;
            } else {
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public List<List<Integer>> createAdjList(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (isDirected) {
                adjList.get(u).add(v);
            } else {
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return adjList;
    }

    public void createAdjListWeights(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected) {
                adjListW.get(u).add(new int[]{v, w});
            } else {
                adjListW.get(u).add(new int[]{v, w});
                adjListW.get(v).add(new int[]{u, w});
            }
        }
    }

    public void printMat() {
        int i = 0;
        for (int[] row : adjMatrix) {
            System.out.println(i++ + " -> " +Arrays.toString(row));
        }
    }

    public void printList() {
        int i = 0;
        for (List<Integer> list : adjList) {
            System.out.println(i++ + " -> " + list);
        }
    }

    public void printListW() {
        int i = 0;
        for (List<int[]> list : adjListW) {
            System.out.print(i++ + " -> ");
            for (int[] edge : list) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int nodes = 4;
        Graph g1 = new Graph(nodes);
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}};
//        // Undirected Graph --> adjMat
//        System.out.println("Undirected Matrix without weights : ");
//        g1.createAdjMat(edges, false);
//        g1.printMat();
//        // Directed Graph --> adjMat
//        System.out.println("Directed Matrix without weights : ");
//        g1.createAdjMat(edges, true);
//        g1.printMat();

//        Graph g2 = new Graph(nodes);
//        // Undirected Graph --> adjList
//        System.out.println("Undirected List without weights : ");
//        g2.createAdlList(edges, false);
//        g2.printList();
//        Graph g3 = new Graph(nodes);
//        // Directed Graph --> adjList
//        System.out.println("Directed List without weights : ");
//        g3.createAdlList(edges, true);
//        g3.printList();

        int[][] edges1 = {{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}, {0,1},{0,2},{0,3}};
        Graph g4 = new Graph(10);
//        g4.createAdjMatWeights(edges1, false);
//        g4.printMat();
        g4.createAdjList(edges1, false);
        g4.printList();
    }
}
