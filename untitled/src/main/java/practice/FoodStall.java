package practice;


import java.util.*;

/**
 * Time: O(N)
 * Space: O(N)
 */
public class FoodStall {

    public static void main(String... args) {
        Map<Integer, List<Integer>> adjacencyList  = new HashMap<>();
        int[][] edges = new int[][] {
                {1, 2},
                {1,-3},
                {2,4},
                {2,-5},
                {3, 6},
                {6, -7}
        };

        for(int [] edge : edges) {
            adjacencyList.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyList.get(edge[0]).add(edge[1]);
        }


    }
    static class TreeNode {
        int val;
        List<TreeNode> children;
        boolean hasApple;

        TreeNode(int val, boolean hasApple) {
            this.val = val;
            this.hasApple = hasApple;
            this.children = new ArrayList<>();
        }
    }

    // use set only incase of cyclic graph.
    private int dfs(TreeNode node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) {
            return 0;
        }

        visited.add(node.val);  // Mark the current node as visited
        int time = 0;

        // Traverse all children
        for (TreeNode child : node.children) {
            // Skip the parent node (which is already visited)
            if (visited.contains(child.val)) {
                continue;
            }

            int childTime = dfs(child, visited);

            // Include time for the child if its subtree contains an apple or if the child itself has an apple
            if (childTime > 0 || child.hasApple) {
                time += childTime + 2; // Add 2 for the round trip to visit the child
            }
        }

        return time;
    }




    private int dfs(TreeNode root) {
      if (root == null) {
          return 0;
      }

      int time = 0;
      for (TreeNode child : root.children) {
          int count = dfs(child);
          if (count > 0 || child.hasApple) {
              time += count + 2;
          }
      }

      return time;
    }

}
