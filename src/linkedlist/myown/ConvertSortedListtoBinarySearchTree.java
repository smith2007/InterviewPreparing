package linkedlist.myown;

import binary_tree.TreeNode;

public class ConvertSortedListtoBinarySearchTree {


  /**
   * суть в чем - надо взять середину массива - это будет наш корень - дальше запускаем дфс на левом
   * и правом поддереве и с помощью инордер траверсал строим наши левое и правое ветви
   */
  private ListNode node;

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }


    int size = 0;
    ListNode runner = head;
    //ноду всегда будем таскать с собой как глобальную переменную
    node = head;
    //нам надо посчитать размер нашего дерева
    while (runner != null) {
      runner = runner.next;
      size++;
    }

    return inorderHelper(0, size - 1);
  }

  public TreeNode inorderHelper(int start, int end) {
    if (start > end) {
      return null;
    }
    //находим миддл
    int mid = start + (end - start) / 2;
    //строим левую часть
    TreeNode left = inorderHelper(start, mid - 1);

    TreeNode newTreeNode = new TreeNode(node.val);
    newTreeNode.left = left;
    node = node.next;
    //и строим на правой части
    TreeNode right = inorderHelper(mid + 1, end);
    newTreeNode.right = right;

    return newTreeNode;
  }

}
