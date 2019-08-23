package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph2 {

    List<Node> nodesAndNeighbors;

    static class Node {
        int value;
        List<Node> neighbors;

        public Node(int value, List<Node> neighbors) {
            this.value = value;
            this.neighbors = neighbors;
        }
    }

    public Graph2(List<Node> nodesAndNeighbors) {
        this.nodesAndNeighbors = nodesAndNeighbors;
    }


    public static void main(String[] args) {
        ArrayList<Node> nodesAndNeighbors = new ArrayList<>();
        ArrayList<Node> neighbors = new ArrayList<>();
        neighbors.add(new Node(2, new ArrayList<>()));
        Node node1 = new Node(1, neighbors);
        nodesAndNeighbors.add(node1);
        Graph2 graph2 = new Graph2(nodesAndNeighbors);
    }
}

