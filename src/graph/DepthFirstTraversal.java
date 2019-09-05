package graph;

public class DepthFirstTraversal {

    public static void main(String[] args) {

        //создаем граф из 4х вершин : 0-1-2-3

        Graph graph = new Graph(4);

        //фигачим связи между ними - ребра
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        dft(0, new boolean[graph.numberOfVertices], graph);

        // 0, 1, 3, 2

    }


    // слоность О (V + E)
    //достаточно простой алгоритм
    //заключается в рекурсивном обходе подмассива соседей
    static void dft(int currNode, boolean[] visited, Graph graph) {
        if (visited[currNode]) {
            return;
        }

        System.out.println("Vertex " + currNode + " has visited");
        visited[currNode] = true;

        for (Integer node : graph.nodesAndNeighbors.get(currNode)) {
            dft(node, visited, graph);
        }

    }
}
