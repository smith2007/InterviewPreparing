package binary_tree;

public class BinaryTreeLongestConsecutiveSequenceII {

  /**
   * define dfs function returns an integer two-element array, int[2]
   *
   * int[0] stores the longest consecutive increasing subsequence from its child node and
   * int[1] stores the longest consecutive decreasing subsequence from its child node
   *
   * rot[0] = Max(left[0], right[0]) {left.val + 1 == val; right.val + 1 == val}
   * rot[1] = Max(left[1], right[1]) {left.val - 1 == val; right.val - 1 == val}
   * rot[0] + rot[1] - 1 is the longest consecutive subsequence through root itself
   * we just update our res(result) when we take each node as root node.
   *
   *
   * решаем через дфс преордер траверсал - то есть сначала обходим ноды - затем рут
   * смотрим что они вернули, можно ли их вообще рассматривать как часть чейна?
   */

  private int res = 0;

  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    //ныряем
    dfs(root);
    return res;
  }

  private int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    //получаем результат слева
    int[] left = dfs(node.left);
    //справа
    int[] right = dfs(node.right);

    //и нам надо сформировать - типа что нам эта нода даст
    //в качестве возрастающей последовательности
    //и в качестве убывающей последовательности
    int[] nodeRes = new int[]{1, 1};

    if (node.left != null) {
      //смотрим если можно левую ноду рассматривать
      // как кусок ВОЗРАСТАЮЩЕГО чейна, т.е. она на 1 больше
      if (node.val == node.left.val + 1) {
        nodeRes[0] = left[0] + 1;
      }

      //можно ли рассмативать как кусок УБЫВАЮЩЕГО ЧЕЙНА?
      if (node.val == node.left.val - 1) {
        nodeRes[1] = left[1] + 1;
      }
    }

    //тоже самое и с правой частью
    if (node.right != null) {
      if (node.val == node.right.val + 1) {
        //вот тут уже надо понимать стоит ли обновлять предыдущее ззначение
        nodeRes[0] = Math.max(nodeRes[0], right[0] + 1);
      }
      if (node.val == node.right.val - 1) {
        nodeRes[1] = Math.max(nodeRes[1], right[1] + 1);
      }
    }

    //ну и результат, обновляем максимум если надо
    res = Math.max(res, nodeRes[0] + nodeRes[1] - 1);

    return nodeRes;
  }

}
