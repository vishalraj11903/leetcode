package practice;

import java.util.*;

import static practice.BeautifulSubset.help;

public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
       Stack<TreeNode> stack = new Stack<>();
       int sum = 0;
       stack.push(root);
       while (!stack.isEmpty()) {
           TreeNode current = stack.pop();
           if (low <= current.val && current.val <= high) {
               sum += current.val;
           }
           if (current.left != null && low < current.val) {
               stack.push(current.left);
           }

           if (current.right != null && current.val < high) {
               stack.push(current.right);
           }
       }

       return sum;
    }

    static List<Integer> index = new ArrayList<>();
    static List<Integer> prefix = new ArrayList<>();
    public static int variant(TreeNode root, int left, int right) {
        computeFirst(root);
        int leftBoundary = leftBoundary(0, index.size() - 1, left);
        int rightBoundary = rightBoundary(0, index.size() - 1, right);

        if (leftBoundary == 0) {
            return prefix.get(rightBoundary);
        }

        return prefix.get(rightBoundary) - prefix.get(leftBoundary - 1);
    }


    private static int rightBoundary(int left, int right, int high) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (index.get(mid) <= high) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int leftBoundary(int left, int right, int lower) {
        int result = index.size();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lower <= index.get(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static void computeFirst(TreeNode root) {
        if (root == null) {
            return;
        }

        computeFirst(root.left);
        index.add(root.val);
        if (prefix.isEmpty()) {
            prefix.add(root.val);
        } else {
            prefix.add(prefix.getLast() + root.val);
        }

        computeFirst(root.right);
    }

    public static void main(String[] args) {
        /**
         *       4
         *   2      6
         * 1   3  5    7
         */
        practice.TreeNode root = new practice.TreeNode(5);
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
        System.out.println(rangeSumBST(root, 4, 6));
        System.out.println(variant(root, 4, 6));
    }
}
