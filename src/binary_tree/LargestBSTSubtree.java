package binary_tree;

public class LargestBSTSubtree {

  public int largestBSTSubtree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (dfsIsValid(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
      return countNodes(root);
    }

    int left = largestBSTSubtree(root.left);
    int right = largestBSTSubtree(root.right);

    return Math.max(left, right);
  }

  //этот метод считает кол во нод но только в том случае если дерево валидное
  private int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  //метод проверяет валидное ли дерево
  private boolean dfsIsValid(TreeNode root, long left, long right) {
    if (root == null) {
      return true;
    }
    if (root.val <= left || root.val >= right) {
      return false;
    }
    return dfsIsValid(root.left, left, root.val) && dfsIsValid(root.right, root.val, right);
  }
}

