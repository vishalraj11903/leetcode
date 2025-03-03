package practice;

import java.util.Stack;

class TreeNode {
    TreeNode(int v) {
        val = v;
        left = right = null;
    }
    int val;
    TreeNode left, right;
}
public class PostOrderIterator {
    Stack<TreeNode> stack = null;
    TreeNode prev;
    PostOrderIterator(TreeNode root) {
        stack = new Stack<>();
        leftPush(root);
    }

    public int next() {
        TreeNode current = null;
        while (hasNext()) {
            current = stack.peek();
            if (current.right != null && current.right != prev) {
                leftPush(current.right);
            } else {
                prev = stack.pop();
                return prev.val;
            }

        }

        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    void leftPush(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        PostOrderIterator iter = new PostOrderIterator(root);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
