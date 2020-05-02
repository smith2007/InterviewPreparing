package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  public static void main(String[] args) {

  }

  /**
   интересный алгоритм, решаем через рекурсию - сначала итерируем массив и выбираем элемент от которого будем плясать
   затем от него расползаемся влево и вправо что бы получить левое и правое поддерево

   */
  public List<TreeNode> generateTrees(int n) {
    //по очереди будем начинать с каждой нодый начиная с первой
    if (n == 0) {
      return new ArrayList<>();
    }
    return genTreeList(1, n);
  }

  private List<TreeNode> genTreeList(int start, int end) {
    List<TreeNode> res = new ArrayList<>();

    if (start > end) {
      res.add(null);
    }

    //каждая наша i-ая нода будет тут РУТОМ
    for (int i = start; i <= end; i++) {
      //строим список если начинать слева
      List<TreeNode> leftNodes = genTreeList(start, i - 1);

      //строим список если начинать справа
      List<TreeNode> rightNodes = genTreeList(i + 1, end);

      //вот тут нам надо
      for (TreeNode leftNode : leftNodes) {
        for (TreeNode rightNode : rightNodes) {

          TreeNode root = new TreeNode(i);
          root.left = leftNode;
          root.right = rightNode;
          res.add(root);
        }
      }
    }
    return res;
  }

}
