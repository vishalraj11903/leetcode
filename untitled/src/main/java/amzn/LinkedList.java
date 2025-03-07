package amzn;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;
    Node random;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
public class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String serialize() {
        Map<Node, Integer> nodeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Node current = head;
        int index = 0;
        while (current != null) {
            nodeMap.put(current, index);
            sb.append(current.data).append(",");
            if (current.random != null) {
                sb.append(nodeMap.get(current.random)).append(",");
            } else {
                sb.append("-1,");
            }
            current = current.next;
            index++;
        }
        return sb.toString();
    }

    public static LinkedList deserialize(String serialized) {
        String[] nodes = serialized.split(",");
        LinkedList linkedList = new LinkedList();
        Node[] nodeArray = new Node[nodes.length / 2];
        for (int i = 0; i < nodes.length; i += 2) {
            Node newNode = new Node(Integer.parseInt(nodes[i]));
            nodeArray[i / 2] = newNode;
            if (i / 2 > 0) {
                nodeArray[i / 2 - 1].next = newNode;
            }
            if (!nodes[i + 1].equals("-1")) {
                newNode.random = nodeArray[Integer.parseInt(nodes[i + 1])];
            }
        }
        linkedList.head = nodeArray[0];
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.head.next.random = linkedList.head; // set random pointer
        linkedList.head.next.next.random = linkedList.head.next; // set random pointer

        String serialized = linkedList.serialize();
        System.out.println("Serialized: " + serialized);

        LinkedList deserializedLinkedList = LinkedList.deserialize(serialized);
        System.out.print("Deserialized: ");
        Node current = deserializedLinkedList.head;
        while (current != null) {
            System.out.print(current.data + " ");
            if (current.random != null) {
                System.out.print("(random: " + current.random.data + ") ");
            }
            current = current.next;
        }
    }
}