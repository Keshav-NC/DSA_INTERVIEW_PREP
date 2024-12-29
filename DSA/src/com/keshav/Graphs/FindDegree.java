package com.keshav.Graphs;

import java.util.Arrays;

public class FindDegree {
    public static void main(String[] args) {
        int nodes = 5;
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(Arrays.toString(findDegreeUD(edges, nodes)));
        findDegreeD(edges, nodes);
    }
    public static int[] findDegreeUD(int[][] edges, int nodes) {
        int[] degree = new int[nodes];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            ++degree[u];
            ++degree[v];
        }
        return degree;
    }
    public static void findDegreeD(int[][] edges, int nodes) {
        int[] inDeg = new int[nodes];
        int[] outDeg = new int[nodes];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            ++inDeg[to];
            ++outDeg[from];
        }
        System.out.println("In Degree" + Arrays.toString(inDeg));
        System.out.println("Out Degree" + Arrays.toString(outDeg));
    }
}
