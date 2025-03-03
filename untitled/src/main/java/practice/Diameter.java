package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diameter {
    static int max = Integer.MIN_VALUE;
    static List<Integer> dia = new ArrayList<>();

    static List<Integer> diameter(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = diameter(root.left);
        List<Integer> right = diameter(root.right);
        int size = left.size() + right.size() + 1;
        if (max < size) {
            max = size;
            dia.clear();

            dia.addAll(left);
            dia.add(root.val);
            Collections.reverse(right);
            dia.addAll(new ArrayList<>(right));
        }

        if (left.size() < right.size()) {
            right.add(root.val);
            return right;
        } else {
            left.add(root.val);
            return left;
        }
    }

    static List<Integer> getDiameter(TreeNode node) {
        calc(node);
        return dia;
    }

    static int calc(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = calc(node.left);
        int right = calc(node.right);
        int size = 1 + left + right;
        if (max < size) {
            max = size;
            dia.clear();
            recordNodes(node.left, true);
            dia.add(node.val);
            recordNodes(node.right, false);
        }

        return 1 + Math.max(left, right);
    }

    static void recordNodes(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        dia.add(node.val);
        if (isLeft) {
            recordNodes(node.left, isLeft);
        } else {
            recordNodes(node.right, isLeft);
        }
    }
    public static void main(String... args) {
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
       // n2.left = n5;
        n2.right = n6;
        n4.right = n5;

        diameter(root);
        System.out.println(dia);
        getDiameter(root);
        System.out.println(dia);
    }
}
