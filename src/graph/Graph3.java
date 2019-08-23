package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph3 {

    int numberOfNodes;
    List<List<Integer>> nodesAndNeighbors;

    public Graph3(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        nodesAndNeighbors = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            nodesAndNeighbors.add(new ArrayList<>());
        }
    }

    void addRelation(int nodeFrom, int nodeTo) {
        if (nodesAndNeighbors == null || nodesAndNeighbors.isEmpty()) {
            return;
        }
        if (nodesAndNeighbors.size() < nodeFrom || nodesAndNeighbors.size() < nodeTo) {
            return;
        }
        List<Integer> neighbors = nodesAndNeighbors.get(nodeFrom);
        neighbors.add(nodeTo);
    }
}
