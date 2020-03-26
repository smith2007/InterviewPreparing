package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKinBinaryTreeWorking {

  public static void main(String[] args) {


  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    annotateParent(map, root, null);

    Set<TreeNode> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    find(res, visited, map, target, 0, K);
    return res;

  }

  //dfs find the dist node
  private void find(List<Integer> res, Set<TreeNode> visited, Map<TreeNode, TreeNode> map,
      TreeNode cur, int dist, int K) {
    if (cur == null || visited.contains(cur)) {
      return;
    }
    if (dist == K) {
      res.add(cur.val);
      return;
    }
    visited.add(cur);
    find(res, visited, map, cur.left, dist + 1, K);
    find(res, visited, map, cur.right, dist + 1, K);
    find(res, visited, map, map.get(cur), dist + 1, K);
  }

  //annotate parent
  private void annotateParent(Map<TreeNode, TreeNode> map, TreeNode cur, TreeNode parent) {
    if (cur != null) {
      map.put(cur, parent);
      annotateParent(map, cur.left, cur);
      annotateParent(map, cur.right, cur);
    }
  }
}
