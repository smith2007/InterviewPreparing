package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyOfGraph {

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val, new ArrayList<>());

        map.put(head, newHead);
        for (Node neighbor : head.neighbors) {
            newHead.neighbors.add(dive(neighbor, map));
        }

        return newHead;
    }

    Node dive(Node curr, Map<Node, Node> map) {
        if (map.containsKey(curr)) {
            return map.get(curr);
        }

        Node newCurr = new Node(curr.val, new ArrayList<>());
        map.put(curr, newCurr);
        for (Node neighbor : curr.neighbors) {
            newCurr.neighbors.add(dive(neighbor, map));
        }
        return newCurr;
    }

    static class Node {
        public int val;
        List<Node> neighbors;

        public Node() {
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
