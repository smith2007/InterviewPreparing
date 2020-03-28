package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKinBinaryTreeWorking {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder.stringToTreeNode("[0,1,null,3,2]");
    TreeNode target = fourthDfs(root, 2);

    AllNodesDistanceKinBinaryTreeWorking inst = new AllNodesDistanceKinBinaryTreeWorking();
    for (Integer integer : inst.distanceK(root, target, 1)) {
      System.out.println(integer);
    }
  }

  /**
   * решать будем через мапу текущего элемента и его родителя интересный подход
   * принцип dfs с шагом вверх
   * нифига себе какой красивый солюшн
   *
   */
  //объявили мапу ключ - нода, value - ee родитель
  Map<TreeNode, TreeNode> map = new HashMap<>();
  //так же нам понадобится сет визитетов
  Set<TreeNode> visited = new HashSet<>();
  //ну и финальный массив резов
  List<Integer> res = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    annotateParent(root, null);

    //опускаемся рекурсией начиная с ТАРГЕТА!!!
    dive(target, 0, k);
    return res;

  }

  //начиная с таргета мы опускаемся в вниз а так же на этаж выше
  //оооочень крутой подход то есть по сути мы расползаемся в разные стороны от нашей ноды
  //вверх и вниз
  private void dive(TreeNode currNode, int distance, int k) {
    //если опустились на дно, либо эту ноду уже посещали
    //ничего не делаем просто возвращаемся
    if (currNode == null || visited.contains(currNode)) {
      return;
    }
    //если мы достигли нашей как бы глубины то все вот она наша нода
    if (distance == k) {
      res.add(currNode.val);
      return;
    }
    //маркируем ноду как посещенную
    visited.add(currNode);
    //идем влево
    dive(currNode.left, distance + 1, k);
    //вправо
    dive(currNode.right, distance + 1, k);
    //а так же - ключевой момент идем на уровень выше для того что бы начать
    // с нашей родительской ноды снова
    dive(map.get(currNode), distance + 1, k);
  }

  //опускаемся через dfs
  private void annotateParent(TreeNode cur, TreeNode parent) {
    //ключ - нода, value - ee родитель
    if (cur != null) {
      map.put(cur, parent);
      annotateParent(cur.left, cur);
      annotateParent(cur.right, cur);
    }
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
