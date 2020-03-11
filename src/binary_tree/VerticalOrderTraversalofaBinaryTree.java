package binary_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class VerticalOrderTraversalofaBinaryTree {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder
        .stringToTreeNode("[0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]");

    verticalTraversal(root);
  }

  static List<List<Integer>> verticalTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    LinkedHashMap<Integer, PriorityQueue<Pair>> map = new LinkedHashMap<>();
    dive(root, 0, map, 0);

    List<List<Integer>> res = new ArrayList<>();
    for (PriorityQueue<Pair> value : map.values()) {
      List<Integer> level = new ArrayList<>();
      for (Pair pair : value) {
        level.add(pair.value);
      }
      res.add(level);
    }

    return res;
  }

  static void dive(TreeNode node, int currVertical, Map<Integer, PriorityQueue<Pair>> map, int level) {
    if (node == null) {
      return;
    }
    dive(node.left, currVertical - 1, map, level + 1);

    PriorityQueue<Pair> verticalList = map
        .getOrDefault(currVertical, new PriorityQueue<>(Comparator.comparingInt(value -> value.depth)));
    verticalList.add(new Pair(node.val, level));
    map.put(currVertical, verticalList);

    dive(node.right, currVertical + 1, map, level + 1);
  }

  static class Pair {

    int value;
    int depth;

    public Pair(int value, int depth) {
      this.value = value;
      this.depth = depth;
    }
  }


}
