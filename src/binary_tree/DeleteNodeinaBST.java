package binary_tree;

public class DeleteNodeinaBST {


  //будем вызывать рекурсивно
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    //ныряем влево или вправо
    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      //тут оказываемся если нашли нужную ноду
      //и и смотрим что же надо линковать левое или правое
      //это зависит от того что есть ли справа или справа ноды - дети
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      //если есть и справа и слева ноды надо найти минимальную из них

      TreeNode minNode = findMin(root.right);
      root.val = minNode.val;
      root.right = deleteNode(root.right, root.val);
    }
    return root;
  }

  private TreeNode findMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }


}
