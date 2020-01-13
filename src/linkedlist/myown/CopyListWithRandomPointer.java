package linkedlist.myown;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

        Node first = new Node(3);
        Node sec = new Node(3);
        Node third = new Node(3);


    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> visited = new HashMap<>();
        return copy(visited, head);
    }

    public Node copy(Map<Node, Node> visited, Node curr) {
        if (curr == null) {
            return null;
        }
        if (visited.containsKey(curr)) {
            return visited.get(curr);
        }
        Node node = new Node(curr.val);
        visited.put(curr, node);
        node.next = copy(visited, curr.next);
        node.random = copy(visited, curr.random);
        return node;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

}
