package com.keshav.Graphs.DSUs;

import java.util.Arrays;

/* Notes :
    Disjoint Set Union (DSU) ->
            * used to solve multiple component questions on graph
            * constant time (4*alpha)
            * DSU's are mostly used in dynamic problems (config keep changing)
            eg. 1 -> 2 -> 3 -> 4  (c1)
                4 -> 6  (c2)
            Patterns ->
                    * How many components are there in graph
                    * is 4 reachable from 1
                    * Does 4 and 6 lies in same component
    DSU ->
            1) Find parent -> find the root of the component
            2) Union(connect two components)
                       a) Union by Rank
                       b) Union by Size
            a) Union by Rank Union(u, v)
                1) find parent of u & v (RPu, RPv)
                2) find rank of (RPu, RPv)
                3) connect smaller rank to larger rank (if same rank connect to any node)
                4) if rank is same increment rank of u, given that v is attached to u
            b) Union by Size Union(u, v)
                        1) find parent of u & v (RPu, RPv)
                        2) find size of (RPu, RPv)
                        3) connect smaller size of comp to larger size comp & increment size of larger comp by smaller size
                        4) if size is same, attach any to any
*/

public class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;
    int components;

    public DisjointSet(int nodes) { // 0-based
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        this.components = nodes;
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
            size[i] = 1; // initial all components will be of size 1
        }
    }

    public int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findRootParent(parent[node]); // path compression
        return parent[node];
    }

    public void unionByRank(int u, int v) {
        // find parent (u, v)
        int rootParentU = findRootParent(u);
        int rootParentV = findRootParent(v);

        // same component
        if (rootParentU == rootParentV) {
            return;
        }

        --components;
        // 3 cases
        if (rank[rootParentU] < rank[rootParentV]) { // ru to rv
            parent[rootParentU] = rootParentV;
        } else if (rank[rootParentU] > rank[rootParentV]) { // rv to ru
            parent[rootParentV] = rootParentU;
        } else { // same rank
            parent[rootParentU] = rootParentV;
            ++rank[rootParentV];
        }
    }

    public void unionBySize(int u, int v) {
        // find parent (u, v)
        int rootParentU = findRootParent(u);
        int rootParentV = findRootParent(v);

        // same component
        if (rootParentU == rootParentV) {
            return;
        }

        --components;
        // 3 cases
        if (size[rootParentU] < size[rootParentV]) { // ru to rv
            parent[rootParentU] = rootParentV;
            size[rootParentV] += size[rootParentU];
        } else { // same rank or >
            parent[rootParentV] = rootParentU;
            size[rootParentU] += size[rootParentV];
        }
    }

    public static void main(String[] args) {
        DisjointSet dsu = new DisjointSet(4);
        // union by rank
//        System.out.println("Total Components : " + dsu.components);
//        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
//        dsu.unionByRank(0, 3);
//        System.out.println("Total Components : " + dsu.components);
//        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        // union by size
        System.out.println("Total Components : " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        dsu.unionBySize(0, 3);
        System.out.println("Total Components : " + dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
    }
}
