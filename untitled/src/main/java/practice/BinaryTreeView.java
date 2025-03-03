package practice;


import java.util.*;

public class BinaryTreeView {
    TreeNode root;
    public BinaryTreeView(TreeNode root) {
        this.root = root;
    }

    List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) {
                result.add(root.val);
            }
            root = root.left;
        }

        return result;
    }

    List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            if (!isLeaf(root)) {
                stack.push(root.val);
            }
            root = root.right;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    void bottom(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            result.add(root.val);
        }

        bottom(root.left, result);
        bottom(root.right, result);
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                if (i == size - 1 || i == 0 || (current.left == null && current.right == null)) {
                    list.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        /**
         *       4
         *   2      6
         * 1   3  5    7
         */
        practice.TreeNode root = new practice.TreeNode(4);
        practice.TreeNode n1 = new practice.TreeNode(2);
        practice.TreeNode n2 = new practice.TreeNode(6);
        practice.TreeNode n3 = new practice.TreeNode(1);
        practice.TreeNode n4 = new practice.TreeNode(3);
        practice.TreeNode n5 = new practice.TreeNode(5);
        practice.TreeNode n6 = new practice.TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        BinaryTreeView iter = new BinaryTreeView(root);
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(iter.leftView(root.left));
        result.addAll(iter.rightView(root.right));
        iter.bottom(root, result);
        System.out.println(result);

        bfs(root);
    }
}
