package practice;

import java.util.ArrayList;
import java.util.List;

class TreeNode1 {
    int val;
    List<TreeNode1> children;

    TreeNode1(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class NAryTreeLongestPath {
    static int max = 0;
    static List<Integer> dia = new ArrayList<>();

    static int calc(TreeNode1 node) {
        if (node == null) {
            return 0;
        }

        // To store sizes of all children
        List<Integer> childSizes = new ArrayList<>();
        for (TreeNode1 child : node.children) {
            childSizes.add(calc(child));
        }

        // Find the two largest sizes among children
        int largest = 0, secondLargest = 0;
        for (int size : childSizes) {
            if (size > largest) {
                secondLargest = largest;
                largest = size;
            } else if (size > secondLargest) {
                secondLargest = size;
            }
        }

        // Calculate the size of the current subtree
        int size = largest + secondLargest + 1; // Including current node
        if (max < size) {
            max = size;

            dia.clear();
            recordNodes(node, largest, secondLargest, childSizes);
        }

        // Return the size of the largest subtree plus the current node
        return largest + 1;
    }

    static void recordNodes(TreeNode1 node, int largest, int secondLargest, List<Integer> childSizes) {
        if (node == null) {
            return;
        }

        // Traverse the largest and second-largest children for the path
        int largestIndex = -1, secondLargestIndex = -1;
        for (int i = 0; i < childSizes.size(); i++) {
            if (childSizes.get(i) == largest && largestIndex == -1) {
                largestIndex = i;
            } else if (childSizes.get(i) == secondLargest && secondLargestIndex == -1) {
                secondLargestIndex = i;
            }
        }

        // Collect nodes from the largest and second-largest subtrees
        if (largestIndex != -1) {
            recordSubtree(node.children.get(largestIndex), true);
        }

        dia.add(node.val); // Add the current node to the path

        if (secondLargestIndex != -1) {
            recordSubtree(node.children.get(secondLargestIndex), false);
        }
    }

    static void recordSubtree(TreeNode1 node, boolean isLeft) {
        if (node == null) {
            return;
        }

        dia.add(node.val);
        for (TreeNode1 child : node.children) {
            recordSubtree(child, isLeft);
        }
    }

    public static void main(String[] args) {
        /**
         * Example Tree:
         *         1
         *     /   |   \
         *    2    3    4
         *   / \        |
         *  5   6       7
         *     /
         *    8
         */
        TreeNode1 root = new TreeNode1(1);
        TreeNode1 n2 = new TreeNode1(2);
        TreeNode1 n3 = new TreeNode1(3);
        TreeNode1 n4 = new TreeNode1(4);
        TreeNode1 n5 = new TreeNode1(5);
        TreeNode1 n6 = new TreeNode1(6);
        TreeNode1 n7 = new TreeNode1(7);
        TreeNode1 n8 = new TreeNode1(8);

        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        n4.children.add(n7);
        n6.children.add(n8);

        calc(root);
        System.out.println("Diameter of the tree: " + max);
        System.out.println("Path contributing to the diameter: " + dia);
    }
}
