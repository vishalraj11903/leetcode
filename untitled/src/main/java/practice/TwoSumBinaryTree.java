package practice;

import java.util.*;

public class TwoSumBinaryTree {

    static boolean twoSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (seen.contains(k - current.val)) {
                    return true;
                }
                list.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            seen.addAll(list);
        }

        return false;
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

        System.out.println(twoSum(root, 11));
    }
}
