package org.example;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean food;
    TreeNode(int val) {
        this.val = val;
    }
}
public class IdentifyRoot {
    /**
     *      1
     *    2   3
     *  4  5
     *
     * @param list
     * @return
     */
    static TreeNode getRoot(List<TreeNode> list) {
        Map<TreeNode, TreeNode> indegree = new HashMap<>();
        TreeNode start = null;
        for (TreeNode val : list) {
            if (val.left != null) {
                indegree.put(val.left, val);
            }
            if (val.right != null) {
                indegree.put(val.right, val);
            }
            if (val.left == null && val.right == null) {
                start = val;
            }
        }

        TreeNode root = start;
        TreeNode parent = null;
        while (root != null) {
            TreeNode tmp = indegree.get(root);
            if (tmp == null) {
                parent = root;
                break;
            }
            root = tmp;
        }

        return parent;
    }



    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        rootRight.food = true;
        TreeNode twoLeft = new TreeNode(4);
        twoLeft.food = true;
        TreeNode twoRight = new TreeNode(5);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(rootLeft);
        list.add(rootRight);
        list.add(twoLeft);
        list.add(twoRight);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = twoLeft;
        rootRight.right = twoRight;

       // System.out.println(getRoot(list).val);
    }
}
