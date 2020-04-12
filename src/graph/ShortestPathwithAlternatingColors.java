package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathwithAlternatingColors {

  /**
   * Use 2 HashMaps to build 2 graphs for the edges of 2 different colors.
   *
   * Start from vertex 0, since we can choose an edge of either color, a 2D array steps is used to store the length of the paths for both colors; Initialized it with MAX_VALUE, except the vertex 0;
   *
   *  Build 2 grapths for the 2 input color edges;
   *
   * Use the vertex number together with the color (0/1) and length, to explore the shortest path to any vertex we can reach by DFS; whenever encountering a vertex, compare with the current length , cnt + 1, and update it if necessary;
   *
   * After DFS, for each vertex, compare the steps for the 2 colors,choose the shorter path; If the shorter path is MAX_VALUE, use-1 instead to indicate a non-exist path.
   */
  private Map<Integer, List<Integer>> red, blue;
  private int[][] steps;

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    // Each vertex has 2 values for starting from red and blue edges, respectively.
    steps = new int[2][n];
    // Initialized with MAX values, except that 2 starting points initialized with 0.
    Arrays.fill(steps[0], 1, n, Integer.MAX_VALUE);
    Arrays.fill(steps[1], 1, n, Integer.MAX_VALUE);
    // Build graphs for red and blue edges, respectively.
    red = new HashMap<>();
    blue = new HashMap<>();
    for (int[] edge : red_edges) {
      red.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
    }
    for (int[] edge : blue_edges) {
      blue.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
    }

    // DFS
    dfs(0, 0, 0);
    dfs(0, 1, 0);

    // Compare the 2 paths for each vertex and choose the shorter one.
    for (int i = 1; i < n; ++i) {
      int shorter = Math.min(steps[0][i], steps[1][i]);
      steps[0][i] = shorter == Integer.MAX_VALUE ? -1 : shorter;
    }
    return steps[0];
  }

  private void dfs(int v, int color, int cnt) {
    Map<Integer, List<Integer>> edges = color == 0 ? red : blue;
    for (int u : edges.getOrDefault(v, new ArrayList<>())) {
      if (steps[1 - color][u] > cnt + 1) {
        steps[1 - color][u] = cnt + 1;
        dfs(u, 1 - color, cnt + 1);
      }
    }
  }
}
