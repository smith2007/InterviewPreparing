package union_find;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

  /**
   * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
   *
   * Example 1:
   *
   * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
   * Output: true
   * Example 2:
   *
   * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
   * Output: false
   * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
   */


  public boolean validTree(int n, int[][] edges) {
    // initialize adjacency list
    List<List<Integer>> adjList = new ArrayList<>(n);

    // initialize vertices
    for (int i = 0; i < n; i++)
      adjList.add(i, new ArrayList<>());

    // add edges
    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }

    boolean[] visited = new boolean[n];

    // make sure there's no cycle
    if (hasCycle(adjList, 0, visited, -1))
      return false;

    // make sure all vertices are connected
    for (int i = 0; i < n; i++) {
      if (!visited[i])
        return false;
    }

    return true;
  }

  // check if an undirected graph has cycle started from vertex u
  boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
    visited[u] = true;

    for (int i = 0; i < adjList.get(u).size(); i++) {
      int v = adjList.get(u).get(i);

      if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
        return true;
    }

    return false;
  }

}
