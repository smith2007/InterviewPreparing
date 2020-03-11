package binary_tree;

public class FlattenBinaryTreetoLinkedList2 {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder.stringToTreeNode("[1,2,5,3,4,null,6]");
    flatten(root);

  }

  static void flatten(TreeNode root) {
    dive(root);
    System.out.println(root);
  }


  static TreeNode dive(TreeNode node) {
    if (node == null) {
      return null;
    }

    if (node.left == null && node.right == null) {
      return node;
    }

    TreeNode leftTail = dive(node.left);
    TreeNode rightTail = dive(node.right);

    if (leftTail != null) {
      leftTail.right = node.right;
      node.right = node.left;
      node.left = null;
    }

    return rightTail == null ? leftTail : rightTail;
  }
}
