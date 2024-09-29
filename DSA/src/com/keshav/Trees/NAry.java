package com.keshav.Trees;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAry {
    class NAryTreeNode <E> {
        E data;
        ArrayList<NAryTreeNode> children;

        public NAryTreeNode (E data) {
            this.data = data;
            children = new ArrayList<>();
        }

        public NAryTreeNode (E data, ArrayList<NAryTreeNode> children) {
            this.data = data;
            this.children = children;
        }
    }

    public ArrayList<Integer> BFS (NAryTreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<NAryTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            NAryTreeNode<Integer> node = queue.poll();
            res.add(node.data);

            for (NAryTreeNode child : node.children) {
                if (child != null) {
                    queue.offer(child);
                }
            }
        }
        return res;
    }


    /*
    // Level wise insertion
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<Node> queue = new LinkedList<>();

            queue.offer (root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();

                while (size > 0) {
                    Node node = queue.poll();
                    levelList.add(node.val);
                    for (Node child : node.children) {
                        if (child != null) {
                            queue.offer (child);
                        }
                    }
                    size--;
                }

                res.add(levelList);
            }
            return res;
        }
    }
   */
}
