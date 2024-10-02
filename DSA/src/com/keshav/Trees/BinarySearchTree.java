package com.keshav.Trees;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeCellRenderer;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {9, 8, 4, 6, 11, 15, 7, 19, 10};
        BinarySearchTree obj = new BinarySearchTree();
        TreeNode root = obj.constructBST(arr);
        obj.inorderTraversal(root);
    }

    public void inorderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public TreeNode constructBST(int[] arr) {
        TreeNode root = null;
        for (int num : arr) {
            root = insertIntoBst(root, num);
        }
        return root;
    }

    public TreeNode insertIntoBst(TreeNode root, int val) {
        // Iterative
        // if root is null, create a new node and make it as root
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode temp = root;
        while (temp != null) {
            if (val < temp.val) {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }

    // Recursive
    public TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else {
            root.right = insertRec(root.right, val);
        }
        return root;
    }
}
