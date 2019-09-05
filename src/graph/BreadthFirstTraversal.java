package graph;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstTraversal {

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


        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        // ну и пробуем обойти этот граф начиная со второй вершины
        bfs(0, graph);

    }


    // ну собственно сам обход графа
    //задаем стартовую точку с которой будем идти
    static void bfs(int rootVertex, Graph graph) {

        //создаем массив уже просмотренных вершин, что бы избежать зацикливания
        boolean[] visited = new boolean[graph.numberOfVertices];

        //содаем связный список который будет очередью
        //в джаве это LinkedList
        LinkedList<Integer> queue = new LinkedList<>();

        //сразу маркируем стартовую вершину как просмотренную
        visited[rootVertex] = true;

        //и ставим эту стартовую вершину в очередь на обход
        queue.add(rootVertex);

        //ну и все, погнали обходить
        while (queue.size() != 0) {
            //извлекаем элемент из очереди и печатаем его
            Integer elm = queue.remove();

            System.out.print(elm + " ");

            //далее берем список соседей
            List<Integer> adjacenciesForVisit = graph.nodesAndNeighbors.get(elm);
            for (Integer adjacencyForFutureVisit : adjacenciesForVisit) {
                //исключаем уже просмотренных соседей
                if (!visited[adjacencyForFutureVisit]) {
                    //и хуярим в очередь на обход
                    queue.add(adjacencyForFutureVisit);
                    visited[adjacencyForFutureVisit] = true;
                }
            }
        }

    }


}
