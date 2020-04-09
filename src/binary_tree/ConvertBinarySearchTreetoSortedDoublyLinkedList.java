package binary_tree;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

  /**
   * работаем через dfs inorder traversal рекурсивно - падаем максимально влево, таскаем с собой
   * prev элемент и линкуем его с текущим
   */
  public static void main(String[] args) {
    ConvertBinarySearchTreetoSortedDoublyLinkedList ins = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
    TreeNode treeNode = ins.treeToDoublyList(StringToNodeBuilder.stringToTreeNode("[4,2,5,1,3]"));
    System.out.println(treeNode);
  }

  TreeNode newHead = null;
  TreeNode tail = null;

  public TreeNode treeToDoublyList(TreeNode root) {
    if (root == null) {
      return null;
    }
    dive(root, null);
    newHead.left = tail;
    tail.right = newHead;
    return newHead;
  }

  public TreeNode dive(TreeNode curr, TreeNode prev) {
  	//падаем максимально влево
    if (curr.left != null) {
      prev = dive(curr.left, prev);
    }
    TreeNode currRight = curr.right;
    curr.left = prev;
    if (prev != null) {
      prev.right = curr;
    }

    if (newHead == null) {
      newHead = curr;
    }
    System.out.println(curr.val);
    if (currRight != null) {
      return dive(currRight, curr);
    }
    tail = curr;
    return curr;
  }


}
