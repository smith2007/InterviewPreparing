package graph;

import java.util.*;

public class CriticalConnectionsinaNetwork {

    public static void main(String[] args) {

        ArrayList<List<Integer>> connections = new ArrayList<>();
        connections.add(List.of(0,1));
        connections.add(List.of(1,2));
        connections.add(List.of(2,0));
        connections.add(List.of(1,3));
        List<List<Integer>> lists = criticalConnections(4, connections);

        for (List<Integer> list : lists) {

            for (Integer integer : list) {
                System.out.print(integer + " ");
            }

            System.out.println();
        }

    }

    static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        //строим граф в виде ноды -> соседи
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> edge : connections) {
            //запомни putIfAbsent - означает добавь ноду в мапу если ее там нет
            graph.putIfAbsent(edge.get(0), new ArrayList<>());
            graph.putIfAbsent(edge.get(1), new ArrayList<>());
            //добавляем наши ноды - сначала как основные, а потом и соседей к ним
            graph.get(edge.get(0)).add(edge.get(1)); //к нулевой ноде будет первый сосед
            graph.get(edge.get(1)).add(edge.get(0)); // и к нашему соседу саму нулевую ноду
        }

        List<List<Integer>> res = new LinkedList<>();
        int[] steps = new int[n];
        Arrays.fill(steps, -1);
        dfs(graph, 0, -1, steps, res, 0);
        return res;
    }

    //возвращать будет минимальное кол-во шагов как бы
    static int dfs(Map<Integer, List<Integer>> graph, int currentNode, int parent, int[] steps, List<List<Integer>> res, int step) {
        steps[currentNode] = step;
        List<Integer> children = graph.get(currentNode);
        int minSteps = step;

        for (Integer child : children) {

            if (child == parent) {
                continue;
            }

            if (steps[child] == -1) {
                int dfs = dfs(graph, child, currentNode, steps, res, step + 1);
                minSteps = Math.min(minSteps, dfs);
            } else if (steps[child] != -1) {
                minSteps = Math.min(minSteps, steps[child]);
            }
        }

        if (minSteps == step && currentNode != 0) {
            List<Integer> criticalConnection = new ArrayList<>();
            criticalConnection.add(currentNode);
            criticalConnection.add(parent);
            res.add(criticalConnection);
        }

        return minSteps;
    }
}
