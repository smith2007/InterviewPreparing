package binary_tree;

public class BinaryTreeMaximumPathSum {

  int sum = Integer.MIN_VALUE;

	//суть какая - ныряем и решаем рекурсией
//что проверяет наш легендарный метод dive?
//в целом его задача это найти лучшие коомбинации для левой и правой подноды,
  public static void main(String[] args) {
    TreeNode treeNode = StringToNodeBuilder
        .stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");

    BinaryTreeMaximumPathSum ins = new BinaryTreeMaximumPathSum();
    System.out.println(ins.maxPathSum(treeNode));
  }

  public int maxPathSum(TreeNode root) {
    dive(root);
    return sum;
  }

  private int dive(TreeNode curr) {
    if (curr == null) {
      return 0;
    }
    //что выгоднее левая часть или правая часть
    //если они принесли отрицательное значение то их смотреть нет смысла
    //пусть будет ноль, что означает что это не будет частью нашей суммы
    int bestFromLeft = Math.max(dive(curr.left), 0);
    int bestFromRight = Math.max(dive(curr.right), 0);

    int prevSum = sum;
    int newSum = bestFromLeft + bestFromRight + curr.val;

    sum = Math.max(prevSum, newSum);
    //ну и вот она заветная коомбинация - возвращаем то что для нас лучше
    //левая часть плюс корень
    //либо правая часть плюс корень
    return Math.max(bestFromLeft, bestFromRight) + curr.val;
  }

}
