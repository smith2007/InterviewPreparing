package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsinaNetwork2 {

  public static void main(String[] args) {

    ArrayList<List<Integer>> connections = new ArrayList<>();
    connections.add(List.of(0, 1));
    connections.add(List.of(1, 2));
    connections.add(List.of(2, 0));
    connections.add(List.of(1, 3));

    CriticalConnectionsinaNetwork2 network2 = new CriticalConnectionsinaNetwork2();
    List<List<Integer>> lists = network2.criticalConnections(4, connections);

    for (List<Integer> list : lists) {
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }

  }

  private List<List<Integer>> ans = new ArrayList<>();

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

      Map<Integer, List<Integer>> graph = new HashMap<>();

    for (List<Integer> c : connections) {
      graph.computeIfAbsent(c.get(0), (k -> new ArrayList<>())).add(c.get(1));
      graph.computeIfAbsent(c.get(1), (k -> new ArrayList<>())).add(c.get(0));
    }
    int[] timestamps = new int[n];
    dfs(graph, 0, 0, 1, timestamps);
    return ans;
  }

  private int dfs(Map<Integer, List<Integer>> graph, int curr, int parent, int currTimestamp,
      int[] timestamps) {

      timestamps[curr] = currTimestamp;

    for (int nextNode : graph.getOrDefault(curr, new ArrayList<>())) {
      if (nextNode == parent) {
        continue;
      }
      if (timestamps[nextNode] > 0) {
        timestamps[curr] = Math.min(timestamps[curr], timestamps[nextNode]);
      } else {
        timestamps[curr] = Math
            .min(timestamps[curr], dfs(graph, nextNode, curr, currTimestamp + 1, timestamps));
      }
      if (currTimestamp < timestamps[nextNode]) {
        ans.add(Arrays.asList(curr, nextNode));
      }
    }
    return timestamps[curr];
  }
}
