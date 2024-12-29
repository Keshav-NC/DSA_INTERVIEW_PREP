package com.keshav.Trees;

import java.util.*;

public class VerticalOrderTraversal {
    class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
        }
    }
    class Pair {
        Node node;
        int col;

        public Pair (Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<Integer> verticalOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            // level wise
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                Node node = pair.node;
                int col = pair.col;
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>(node.data));
                }
                map.get(col).add(node.data);
                if (node.left != null) {
                    queue.offer(new Pair(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, col + 1));
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                Collections.sort(list);
                res.addAll(list);
            }
        }
        return res;
    }
}
