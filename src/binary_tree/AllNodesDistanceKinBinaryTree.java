package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKinBinaryTree {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder.stringToTreeNode("[0,null,1,null,2,null,3,4]");
    TreeNode target = fourthDfs(root, 2);

    /**

     2
     2
     */
/*    TreeNode root = StringToNodeBuilder.stringToTreeNode("[0,1,null,3,2]");
    TreeNode target = fourthDfs(root, 2); */

    AllNodesDistanceKinBinaryTree inst = new AllNodesDistanceKinBinaryTree();
    for (Integer integer : inst.distanceK(root, target, 2)) {
      System.out.println(integer);
    }

  }


  int targetDepth = 0;
  List<Integer> res = new ArrayList<>();
  Map<TreeNode, Integer> map = new HashMap<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    firstDfs(root, target, 0, k);
    if (targetDepth == k) {
      res.add(root.val);
    }
    thirdDfs(root, target, -1 * targetDepth, k);
    return res;
  }

  Integer firstDfs(TreeNode curr, TreeNode target, int currDepth, int k) {
    if (curr == null) {
      return null;
    }
    if (curr.equals(target)) {
      targetDepth = currDepth;
      map.put(target, 0);
      secondDfs(curr, 0, k);
      return currDepth - 1;
    }

    Integer depthIfFoundLeft = firstDfs(curr.left, target, currDepth + 1, k);
    Integer depthIfFoundRight = firstDfs(curr.right, target, currDepth + 1, k);

    if (k == 0) {
      return null;
    }
    if (depthIfFoundLeft == null && depthIfFoundRight == null) {
      return null;
    }
    if (depthIfFoundLeft != null) {
      map.put(curr, depthIfFoundLeft);
      if (depthIfFoundLeft == k) {
        res.add(curr.val);
      } else {
        return depthIfFoundLeft - 1;
      }
    } else {
      map.put(curr, depthIfFoundRight);
      if (depthIfFoundRight == k) {
        res.add(curr.val);
      } else {
        return depthIfFoundRight - 1;
      }
    }
    return null;
  }

  void secondDfs(TreeNode curr, int currDepth, int k) {

    if (curr == null) {
      return;
    }
    map.put(curr, currDepth);
    if (currDepth == k) {
      res.add(curr.val);
      return;
    }

    secondDfs(curr.left, currDepth + 1, k);
    secondDfs(curr.right, currDepth + 1, k);
  }

  void thirdDfs(TreeNode curr, TreeNode target, int newCurrDepth, int k) {

    if (curr == null || curr.equals(target)) {
      return;
    }

    if (Math.abs(newCurrDepth) == Math.abs(k) && !map.containsKey(curr)) {
      res.add(curr.val);
      return;
    }

    thirdDfs(curr.left, target, newCurrDepth - 1, k);
    thirdDfs(curr.right, target, newCurrDepth - 1, k);
  }


  private static TreeNode fourthDfs(TreeNode curr, int n) {
    if (curr == null) {
      return null;
    }

    if (curr.val == n) {
      return curr;
    }
    TreeNode rightRes = fourthDfs(curr.right, n);
    TreeNode leftRes = fourthDfs(curr.left, n);
    return rightRes != null ? rightRes : leftRes;
  }

}
