package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedWeight {
    static class Node {
        int depth;
        int val;
        Node(int depth, int val) {
            this.depth = depth;
            this.val = val;
        }
    }
    public static void main(String... args) {
        // {{1,2}, 1, {2,3}} -> 17
        List<Node> list = new ArrayList<>();
        list.add(new Node(2, 1));
        list.add(new Node(2, 2));
        list.add(new Node(1, 1));
        list.add(new Node(2, 2));
        list.add(new Node(2, 3));

        int result = 0;
        for (Node node : list) {
            result += (node.val * node.depth);
        }

        System.out.println(result);
    }
}
