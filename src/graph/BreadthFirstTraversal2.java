package graph;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstTraversal2 {

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        //фигачим связи между ними - ребра
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        bft(graph, 0);
    }


    static void bft(Graph graph, Integer startPoint) {

        boolean[] seen = new boolean[graph.numberOfVertices];
        seen[startPoint] = true;

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(startPoint);

        while (queue.size() != 0) {
            Integer elm = queue.remove();
            System.out.println(elm);

            List<Integer> neig = graph.nodesAndNeighbors.get(elm);

            for (Integer neigg : neig) {

                if (!seen[neigg]) {
                    queue.add(neigg);
                    seen[neigg] = true;
                }
            }
        }

    }
}
