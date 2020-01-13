package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) {

    }

    /**
     *
     https://leetcode.com/problems/clone-graph/

     дан граф в виде node -> list of neighbors необходимо сделать deep копию этого графа,
     поступаем таким же макаром - а именно делаем мапу visited - Map<Node, Node> где ключ это старая нода а
     значение новая нода, раскручиваем рекурсию возвращаем результат
     */

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return copy(visited, node);

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
        List<Node> neig = new ArrayList<>();
        for (Node neighbor : curr.neighbors) {
            neig.add(copy(visited, neighbor));
        }
        node.neighbors = neig;
        return node;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
