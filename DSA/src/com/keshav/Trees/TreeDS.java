package com.keshav.Trees;
import java.util.*;
public class TreeDS {
    class TreeNode<E> {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode (E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
    }

    public static ArrayList<Integer> BFS (TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // firstly -> add the root node to the queue
        queue.offer(root);

        // add all the directed nodes to the queue, loop it until queue becomes empty
        while (!queue.isEmpty()) {
            // check the children of the current node
            TreeNode<Integer> node = queue.poll();
            res.add(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }
}
