package com.keshav.Graphs;

import java.util.*;

public class Graph {

    class Pair {
        int node;
        int weight;
        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }

        @Override
        // (node, weight)
        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
    }
    int[][] adjMatrix;
    // list without weights
    List<List<Integer>> adjList;
    // list with weights
    List<List<Pair>> adjListWeight;

    Graph(int nodes) {
        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListWeight = new ArrayList<>();

        // initialize empty lists
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWeight.add(new ArrayList<>());
        }
    }

    // [[0, 1], [1, 0], [2, 0]]
    public void addEdgesInMatrix(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // directed
            if (isDirected) {
                adjMatrix[u][v] = 1;
            } else {
                // undirected
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesWithWeightInMatrix(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2]; // weight

            // directed
            if (isDirected) {
                adjMatrix[u][v] = w;
            } else {
                // undirected
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public void addEdgesInList(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // directed
            if (isDirected) {
                adjList.get(u).add(v);
            } else {
                // undirected
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    public void addEdgesWithWeightInList(int[][] edges, boolean isDirected) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // directed
            if (isDirected) {
                Pair pair = new Pair(v, w);
                adjListWeight.get(u).add(pair);
            } else {
                // undirected
                Pair pair1 = new Pair(v, w);
                Pair pair2 = new Pair(u, w);
                adjListWeight.get(u).add(pair1);
                adjListWeight.get(v).add(pair2);
            }
        }
    }

    public void printMatrix() {
//        for (int i = 0; i < adjMatrix.length; i++) {
//            for (int j = 0; j < adjMatrix[i].length; j++) {
//                System.out.print(adjMatrix[i][j] + " ");
//            }
//        System.out.println();
//        }
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void printList() {
        int i = 0;
        for (List<Integer> row : adjList) {
            System.out.println(i++ + " -> " + row);
        }
    }

    public void printWeightedList() {
        for (int i = 0; i < adjListWeight.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
                for (int j = 0; j < adjListWeight.get(i).size(); j++) {
                    System.out.print(adjListWeight.get(i).get(j));
                    if (j != adjListWeight.get(i).size() - 1) {
                        System.out.print(", ");
                    }
                }
            System.out.print("]");
            System.out.println();
        }
    }

    public void findDegreeInUD(int[][] edges) {
        int[] degree = new int[edges.length + 1];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degree[u]++;
            degree[v]++;
        }
        int i = 0;
        for (int d : degree) {
            System.out.println(i++ + " -> " + d);
        }
    }

    public void findDegreeInD(int[][] edges) {
        int[] inDeg = new int[edges.length + 1];
        int[] outDeg = new int[edges.length + 1];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            outDeg[from]++;
            inDeg[to]++;
        }
        for (int i = 0; i < edges.length; i++) {
            System.out.print("in-degree -> " + inDeg[i] + " - ");
            System.out.println("out-degree -> " + outDeg[i]);
        }
    }

    // Homework
    public void findDegreeInMatrix(boolean isDirected) {
        int count = 0;
        if (isDirected) {
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix[0].length; j++) {
                    if (adjMatrix[i][j] == 1) {
                        ++count;
                    }
                }
                System.out.println(i + " -> " + count);
                count = 0;
            }
        }
    }


    // Depth First Search
    public void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> res) {
        // mark current node as visited
        visited[node] = true;
        // add the visited node to the res
        res.add(node);
        for (int neighbour : adj.get(node)) {
            if (!visited[node]) {
                dfs(neighbour, visited, adj, res);
            }
        }
    }

    // Breadth First Search --> source given eg start from 0
    // for SINGLE SOURCE
    public void bfs(int source, List<List<Integer>> adj, List<Integer> res, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        // mark the source node as visited
        visited[source] = true;

        queue.offer(source);

        // run loop till the queue gets empty
        while (!queue.isEmpty()) {
            // remove the inserted node
            int node = queue.poll();
            res.add(node);
            // insert the direct neighbours of the "node"
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    // mark the neighbour as visited
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    // for MULTIPLE SOURCE
    public List<Integer> bfsMultipleSrc(int N, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N];
        List<Integer> res = new ArrayList<>();

        // for multiple components
        // traverse the visited node, find the unvisited node
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i, adj, res, visited);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*
        // Adjacency Matrix
        // without weights
        int[][] edges = {{0, 2}, {0, 1}, {1,3}};
        int nodes = 4;
        System.out.println("Undirected graph");
        Graph graph = new Graph(nodes);
        graph.addEdgesInMatrix(edges, false);
        graph.printMatrix();

        System.out.println("Directed Graph");
        Graph graph1 = new Graph(nodes);
        graph1.addEdgesInMatrix(edges, true);
        graph1.printMatrix();
        */

        /*
        // Adjacency Matrix
        // with weights
        int[][] edges = {{0, 2, 10}, {0, 1, 20}, {1,3, 30}};
        int nodes = 4;
        System.out.println("UnDirected graph");
        Graph graph = new Graph(nodes);
        graph.addEdgesWithWeightInMatrix(edges, false);
        graph.printMatrix();
        System.out.println("Directed graph");
        Graph graph1 = new Graph(nodes);
        graph1.addEdgesWithWeightInMatrix(edges, true);
        graph1.printMatrix();
        */

        /*
        // Adjacency List
        int[][] edges = {{0, 2}, {0, 1}, {2,3}};
        int nodes = 4;
        System.out.println("UnDirected graph");
        Graph graph = new Graph(nodes);
        graph.addEdgesInList(edges, false);
        graph.printList();
         */
        /*
        int[][] edges = {{0, 2, 10}, {0, 1, 20}, {1,3, 30}};
        int nodes = 4;
        System.out.println("UnDirected graph");
        Graph graph = new Graph(nodes);
        graph.addEdgesWithWeightInList(edges, false);
        graph.printWeightedList();
        System.out.println("Directed graph");
        Graph graph1 = new Graph(nodes);
        graph1.addEdgesWithWeightInList(edges, true);
        graph1.printWeightedList();
         */
        /*
        // Finding Degree
        int[][] edges = {{0, 2, 10}, {0, 1, 20}, {1,3, 30}};
        Graph graph = new Graph(4);
        System.out.println("UnDirected");
        graph.findDegreeInUD(edges);
        System.out.println("Directed");
        graph.findDegreeInD(edges);
         */
        // Home work
        // {{0, 2}, {0, 1}, {1, 3}}
        int[][] edges = {{0, 2}, {0, 1}, {1, 3}};
        int nodes = 4;
        Graph graph = new Graph(nodes);
        graph.addEdgesInMatrix(edges, true);
    }
}
