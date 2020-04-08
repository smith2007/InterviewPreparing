package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph {

  public static void main(String[] args) {
    int[][] graph = {{0, 1}, {1, 2}, {3, 4}};
    NumberofConnectedComponentsinanUndirectedGraph ins = new NumberofConnectedComponentsinanUndirectedGraph();
    System.out.println(ins.countComponents(4, graph));
  }

  public int countComponents(int n, int[][] edges) {
    Node[] nodes = new Node[n];

    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }
    for (int[] edge : edges) {
      int left = edge[0];
      int right = edge[1];

      Node leftNode = nodes[left];
      Node rightNode = nodes[right];

      leftNode.neighbors.add(rightNode);
      rightNode.neighbors.add(leftNode);

      nodes[left] = leftNode;
      nodes[right] = rightNode;
    }
    int count = 0;

    for (Node node : nodes) {
      count += dive(node);
    }
    return count;
  }


  int dive(Node curr) {
    if (curr == null || curr.color != -1) {
      return 0;
    }
    curr.color = 1;
    for (Node neighbor : curr.neighbors) {
      dive(neighbor);
    }
    return 1;
  }

  static class Node {

    int val;
    int color = -1;
    List<Node> neighbors = new ArrayList<>();

    public Node(int val) {
      this.val = val;
    }
  }
}
