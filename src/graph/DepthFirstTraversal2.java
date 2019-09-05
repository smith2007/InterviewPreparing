package graph;

import java.util.List;

public class DepthFirstTraversal2 {


    public static void main(String[] args) {
        Graph graph = new Graph(4);

        //фигачим связи между ними - ребра
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        dft(graph, 0);
    }


    static void dft(Graph graph, int elm) {


        System.out.println(elm);
        List<Integer> neighs = graph.nodesAndNeighbors.get(elm);
        for (Integer neig : neighs) {
            if (elm != neig) {
                dft(graph, neig);
            }
        }
    }
}
