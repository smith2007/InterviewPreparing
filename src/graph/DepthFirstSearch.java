package graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph3 graph3 = new Graph3(6);
        graph3.addRelation(0, 1);
        graph3.addRelation(0, 2);
        graph3.addRelation(2, 1);
        graph3.addRelation(1, 3);
        graph3.addRelation(2, 4);
        graph3.addRelation(3, 4);
        graph3.addRelation(3, 5);

        int root = 2;
        int target = 5;
        boolean result = dfs(graph3, root, target);
        System.out.println("There " + (result ? "is" : "is not") + " route from " + root + " to target " + target);

    }


    static boolean dfs(Graph3 graph3, int root, int target) {
        boolean[] visited = new boolean[graph3.numberOfNodes];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(root);

        return visit(graph3, target, queue, visited);

    }

    private static Boolean visit(Graph3 graph3, int target, LinkedList<Integer> queue, boolean[] visited) {

        if (queue.isEmpty()) {
            return false;
        }
        Integer elm = queue.poll();
        if (visited[elm]) {
            return false;
        }

        if (elm == target) {
            return true;
        } else {
            visited[elm] = true;
            List<Integer> neighbors = graph3.nodesAndNeighbors.get(elm);
            for (Integer node : neighbors) {
                queue.push(node);
                Boolean result = visit(graph3, target, queue, visited);
                if (result) {
                    return true;
                }
            }
            return false;

        }


    }


}
