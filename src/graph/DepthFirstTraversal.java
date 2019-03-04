package graph;

public class DepthFirstTraversal {

    public static void main(String[] args) {

        //создаем граф из 4х вершин : 0-1-2-3
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 1);

        dft(0, new boolean[graph.numberOfVertices], graph);

        // 0, 1, 3, 2

    }


    // слоность О (V + E)
    //достаточно простой алгоритм
    //заключается в рекурсивном обходе подмассива соседей
    static void dft(int currVertex, boolean[] visited, Graph graph) {
        if (visited[currVertex]) {
            return;
        }

        System.out.println("Vertex " + currVertex + " has visited");
        visited[currVertex] = true;

        for (Integer adj : graph.adjacencyLists.get(currVertex)) {
            dft(adj, visited, graph);
        }

    }
}
