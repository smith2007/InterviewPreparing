package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree2 {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder
        .stringToTreeNode("[0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]");

    verticalTraversal(root);
  }


  static List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    dive(root, 0, 0, map);

    List<List<Integer>> list = new ArrayList<>();
    for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
      list.add(new ArrayList<>());
      for (PriorityQueue<Integer> nodes : ys.values()) {
        while (!nodes.isEmpty()) {
          list.get(list.size() - 1).add(nodes.poll());
        }
      }
    }
    return list;
  }

  static void dive(TreeNode root, int verticalNo, int level,
      TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(verticalNo)) {
      map.put(verticalNo, new TreeMap<>());
    }
    if (!map.get(verticalNo).containsKey(level)) {
      map.get(verticalNo).put(level, new PriorityQueue<>());
    }
    map.get(verticalNo).get(level).add(root.val);
    dive(root.left, verticalNo - 1, level + 1, map);
    dive(root.right, verticalNo + 1, level + 1, map);
  }

}
