package graph;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearсh {

    public static void main(String[] args) {
        Graph3 graph3 = new Graph3(6);
        graph3.addRelation(0, 1);
        graph3.addRelation(0, 2);
        graph3.addRelation(2, 1);
        graph3.addRelation(1, 3);
        graph3.addRelation(2, 4);
        graph3.addRelation(3, 4);
        graph3.addRelation(3, 5);

        int root = 1;
        int target = 5;
        boolean result = bfs(graph3, root, target);
        System.out.println("There " + (result ? "is" : "is not") + " route from " + root + " to target " + target);



        int root1 = 2;
        int target1 = 5;
        boolean result1 = bfs(graph3, root1, target1);
        System.out.println("There " + (result1 ? "is" : "is not") + " route from " + root1 + " to target " + target1);
    }

    static boolean bfs(Graph3 graph3, int root, int target) {

        boolean[] alreadyVisited = new boolean[graph3.numberOfNodes];

        // очередь для обхода
        // сразу добавляем первый набор для обхода
        LinkedList<Integer> queue = new LinkedList<>();

        queue.push(root);

        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            Integer node = queue.poll();
            if (alreadyVisited[node]) {
                continue;
            }
            if (node == target) {
                return true;
            } else {
                alreadyVisited[node] = true;
                List<Integer> nextNodes = graph3.nodesAndNeighbors.get(node);
                for (Integer nextNode : nextNodes) {
                    queue.push(nextNode);
                }
            }
        }
        return false;
    }


}
