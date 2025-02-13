package com.keshav.Graphs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {
                {1,4},{2,4},{3,1},{3,2}
        };
        System.out.println(canFinish(numCourses, prerequisites));

    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            // directed
            adj[u].add(v);
        }
        System.out.println(Arrays.toString(adj));
        return !detectCycle(adj, numCourses);
    }

    private static boolean detectCycle(List<Integer>[] adj, int n) {
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && checkIfCycle(i, adj, visited, pathVisited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfCycle(int source, List<Integer>[] adj, boolean[] visited, boolean[] pathVisited) {
        visited[source] = true;
        pathVisited[source] = true;
        for (int neighbour : adj[source]) {
            if (pathVisited[neighbour]) return true;
            else if (visited[neighbour]) continue;
            else {
                if (checkIfCycle(neighbour, adj, visited, pathVisited)) return true;
            }
        }
        pathVisited[source] = false;
        return false;
    }
}
