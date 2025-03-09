package amzn;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int data) {
        this.val = data;
        this.next = null;
        this.random = null;
    }
}
public class LinkedList1 {
    // Serialize to string
    public static String serialize(Node head) {
        if (head == null) {
            return "";
        }

        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Node current = head;
        int index = 0;

        while (current != null) {
            nodeToIndex.put(current, index);
            current = current.next;
            index++;
        }

        current = head;
        StringJoiner joiner = new StringJoiner(",");

        while (current != null) {
            int randomIdx = (current.random != null) ? nodeToIndex.get(current.random) : -1;
            joiner.add(current.val + ":" + randomIdx);
            current = current.next;
        }

        return joiner.toString();
    }

    static String ser(Node head) {
        Node current = head;
        Map<Node, Integer> map = new HashMap<>();
        int index = 0;
        while (current != null) {
            map.put(current, index++);
            current = current.next;
        }

        StringJoiner joiner = new StringJoiner(",");
        current = head;
        while (current != null) {
            int rnd = current.random == null ? -1 : map.get(current.random);
            joiner.add(current.val + ":" + rnd);
            current = current.next;
        }

        return joiner.toString();
    }

    static Node des(String input) {
        String[] stringNodes = input.split(",");
        Node[] nodes = new Node[stringNodes.length];

        for (int i = 0; i < stringNodes.length; ++i) {
            int val = Integer.valueOf(stringNodes[i].split(":")[0]);
            nodes[i] = new Node(val);
        }

        for (int i = 0; i < stringNodes.length ; ++i) {
            if (i < stringNodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
            int val = Integer.valueOf(stringNodes[i].split(":")[1]);
            nodes[i].random = val == -1 ? null : nodes[val];
        }

        return nodes[0];
    }

    // Deserialize from string
    public static Node deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] parts = s.split(",");
        Node[] nodes = new Node[parts.length];

        for (int i = 0; i < parts.length; i++) {
            String[] nodeData = parts[i].split(":");
            nodes[i] = new Node(Integer.parseInt(nodeData[0]));
        }

        for (int i = 0; i < parts.length; i++) {
            String[] nodeData = parts[i].split(":");
            int randomIdx = Integer.parseInt(nodeData[1]);

            if (i < parts.length -1) {
                nodes[i].next = nodes[i+1];
            }

            if (randomIdx != -1) {
                nodes[i].random = nodes[randomIdx];
            }
        }

        return nodes[0];
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Value: " + current.val + ", Random: " + (current.random != null ? current.random.val : "null") + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node3;
        node2.random = head;
        node3.random = node4;
        node4.random = node2;

        System.out.println("Original List:");
        printList(head);

        String serialized = ser(head);
        System.out.println("Serialized: " + serialized);

        Node deserialized = des(serialized);
        System.out.println("Deserialized List:");
        printList(deserialized);
    }
}