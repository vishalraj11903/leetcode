package practice;

import java.util.*;

public class CommonAncestor {
    public static void main(String... args) {
        int[][] input = {
                {1, 2}, {1, 3}, {5, 4}, {6, 4}, {3, 4}
        };

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] value : input) {
            int parent = value[0];
            int child = value[1];
            adj.putIfAbsent(child, new ArrayList<>());
            adj.get(child).add(parent);
        }

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        find(adj, path1, 4);
        find(adj, path2, 2);

        for (int val : path1) {
            if (path2.contains(val)) {
                System.out.println(val);
                break;
            }
        }

    }

    static void find(Map<Integer, List<Integer>> adj, List<Integer> list, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int current = queue.poll();
                list.add(current);
                if (adj.containsKey(current)) {
                    for (int val : adj.get(current)) {
                        queue.add(val);
                    }
                }
            }
        }
    }
}
