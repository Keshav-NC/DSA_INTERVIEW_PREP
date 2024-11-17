package com.keshav.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cousins {
    class Node {
        int val;
        Node left;
        Node right;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public Node (int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public boolean isCousins (Node root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int childCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // level wise
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int sameParentCount = 0;
                if (node.left != null) {
                    if (node.left.val == x || node.left.val == y) {
                        ++childCount;
                        ++sameParentCount;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x || node.right.val == y) {
                        ++childCount;
                        ++sameParentCount;
                    }
                    queue.offer(node.right);
                }
                if (sameParentCount == 2) {
                    return false;
                }
            }
            if (childCount == 2) {
                return true;
            }
            if (childCount == 1) {
                return false;
            }
        }
        return false;
    }
}
