package com.keshav.Trees;

import javax.imageio.ImageTranscoder;
import java.util.List;

public class DiameterOfTree {
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

    // Depth of the binary tree
    public int maxDepth (Node root) {
        int[] maxi = new int[1]; // pass by reference
        findDepth(root, maxi);
        return maxi[0];
    }

    private int findDepth(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findDepth(root.left, maxi);
        int rightHeight = findDepth(root.right, maxi);
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);
        return (1 + Math.max(leftHeight, rightHeight));
    }

    // Diameter of the binary tree
    public int diameterBT (Node root) {
        int[] maxi = new int[1]; // pass by reference
        findHeightBT (root, maxi);
        return maxi[0];

    }
    private int findHeightBT(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        // find the left height tree
        int leftHeight = findHeightBT(root.left, maxi);
        // find the right height of tree
        int rightHeight = findHeightBT(root.left, maxi);
        // find the maximum path
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);

        return (1 + Math.max(leftHeight, rightHeight));
    }

    public int maxDiameterNary (Node root) {
        int[] maxi = new int[1];
        findHeightNary(root, maxi);
        return maxi[0];
    }

    private int findHeightNary(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        int h1 = 0;
        int h2 = 0;
        int h = 0;

        for (Node child : root.children) {
            h = findHeightNary(child, maxi);
            if (h > h1) {
                h2 = h1;
                h1 = h;
            } else if (h > h2) {
                h2 = h;
            }

        }
        maxi[0] = Math.max(maxi[0], h1 + h2);
        return (1 + h1);
    }

    // Count the number of nodes in a balanced tree --> O(N)
    public int countNodes (Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return (1 + leftNodes + rightNodes);
    }

    // with O(log2N)^2
    public int count (Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = findLeftNodes (root.left);
        int rightNodes = findRightNodes (root.right);

        // formulae --> (2^h - 1) --> h -> height of tree
        if (leftNodes == rightNodes) {
            return ((int) Math.pow(2, leftNodes) - 1);
        }

        return (1 + count(root.left) + count(root.right));
    }

    private int findLeftNodes(Node root) {
        int count = 1; // root node
        while (root != null) {
            ++count;
            root = root.left;
        }
        return count;
    }
    private int findRightNodes(Node root) {
        int count = 1; // root node
        while (root != null) {
            ++count;
            root = root.right;
        }
        return count;
    }
}
