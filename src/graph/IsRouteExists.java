package graph;

import java.util.LinkedList;

public class IsRouteExists {

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 3);

        int pointA = 0;
        int pointB = 3;
        boolean routeExists = isRouteExists(pointA, pointB, graph);


        System.out.println("Route between vertices " + pointA + " and "
                + pointB + (routeExists ? " is" : " isn't") + " exists");
    }

    static boolean isRouteExists(int pointA, int pointB, Graph graph) {

        if (pointA == pointB) {
            return true;
        }

        boolean[] visited = new boolean[graph.numberOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(pointA);

        while (queue.size() != 0) {
            Integer elm = queue.poll();
            if (elm == pointB) {
                return true;
            } else if (!visited[elm]) {
                visited[elm] = true;
                for (Integer adj : graph.adjacencyLists.get(elm)) {
                    queue.push(adj);
                }
            }
        }

        return false;
    }
}
