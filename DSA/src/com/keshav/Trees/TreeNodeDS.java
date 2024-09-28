package com.keshav.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNodeDS {
    int val;
    TreeNodeDS left;
    TreeNodeDS right;

    public TreeNodeDS() {}
    public  TreeNodeDS(int val) {
        this.val = val;
    }

    // Traversals
    // 1) Recursive approach
    // Preorder traversal --> Root, Left, Right
    public void preorderRec (TreeNodeDS root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val); // add root data
        preorderRec(root.left, ans); // move to left
        preorderRec(root.right, ans); // move to right
    }

    // Inorder traversal --> Left, Root, Right
    public void inorderRec (TreeNodeDS root, List<Integer> ans) {
        if (root == null) return;
        inorderRec(root.left, ans); // move to left
        ans.add(root.val); // add root data
        inorderRec(root.right, ans); // move to right
    }

    // Postorder traversal --> Left, Right, Root
    public void postorderRec (TreeNodeDS root, List<Integer> ans) {
        if (root == null) return;
        postorderRec(root.left, ans); // move to left
        postorderRec(root.right, ans); // move to right
        ans.add(root.val); // add root data
    }

    // 2) Iterative approach
    // Preorder --> Root, Left, Right
    public List<Integer> preorderItv (TreeNodeDS root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans; // return an empty list
        }

        Stack<TreeNodeDS> stack = new Stack<>();

        // add root to stack
        stack.push(root);

        while (!stack.isEmpty()) {
            // pop the top of the stack
            TreeNodeDS node = stack.pop();

            // process the root
            ans.add(node.val);

            // process left child
            if (node.left != null) {
                stack.push(node.left);
            }

            // process right child
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    // Inorder --> Left, Root, Right
    public List<Integer> inorderItv (TreeNodeDS root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNodeDS> stack = new Stack<>();
        TreeNodeDS node = root;

        while (node != null || !stack.isEmpty()) {
            // move to left till null
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // process root data
            node = stack.pop();
            ans.add(node.val);

            // move to right
            node = node.right;
        }
        return ans;
    }

    // Postorder --> Left, Right, Root
    public List<Integer> postorderItv (TreeNodeDS root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNodeDS> stack = new Stack<>();
        TreeNodeDS node = root;

        while (node != null || !stack.isEmpty()) {
            // move to left
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // move to right
            // case 1: check stack's top's right is not null, then process the right
            // case 2: if null, pop and store it in temp, to check if it is right child of stack's peek element
            if (stack.peek().right != null) {
                stack.push(stack.peek().right);
            } else {
                TreeNodeDS temp = stack.pop();
                ans.add(temp.val);
                if (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    ans.add(temp.val);
                }
            }
        }
        return ans;
    }
}
