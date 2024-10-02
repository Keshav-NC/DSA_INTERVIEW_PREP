package com.keshav.Trees;

public class LowestCommonAncestor {
    class Node {
        int val;
        Node left;
        Node right;

        Node (int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    /*
        The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     */
    public Node LCA(Node root, Node p, Node q) {
        // if the target reached return the target
        if (root == null || root == p || root == q) {
            return root;
        }

        Node leftChild = LCA(root.left, p, q);
        Node rightChild = LCA(root.right, p, q);
        // both left and right are not null, we found the ans
        if (leftChild != null && rightChild != null) {
            return root;
        }
        // if one of the node is "NON-NULL" node then return the "NON-NULL" node
        return leftChild == null ? rightChild : leftChild;
    }
}
