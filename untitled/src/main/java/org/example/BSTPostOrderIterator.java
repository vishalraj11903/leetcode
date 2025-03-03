package org.example;

import java.util.Stack;

public class BSTPostOrderIterator {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
       /* root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/

        BSTPostOrderIterator iterator = new BSTPostOrderIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // Output: 4 5 2 3 1
        }
    }

    Stack<TreeNode> stack;
    TreeNode lastVisited;

    public BSTPostOrderIterator(TreeNode root) {
        stack = new Stack<>();
        lastVisited = null;
        left(root);
    }

    /**
     *       1
     *     2   3
     *   4       5
     * @return
     */

    public int next() {
       /* TreeNode current = stack.peek();
        if (current.right != null && lastVisited != current.right) {
            left(current.right);
        } else {
            lastVisited = current;
            current = stack.pop();
            return current.val;
        }
        return next();*/

        TreeNode current = stack.peek();
        while (hasNext()) {
            if (current.right != null && current.right != lastVisited) {
                left(current.right);
            } else {
                lastVisited = current;
                return stack.pop().val;
            }
        }

        return -1;
    }

    private void left(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
