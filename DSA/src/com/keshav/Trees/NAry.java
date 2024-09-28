package com.keshav.Trees;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
}
