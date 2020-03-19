package binary_tree;

public class FlattenBinaryTreetoLinkedList {

  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder.stringToTreeNode("[1,2,5,3,4,null,6]");

    flatten(root);

  }

  static void flatten(TreeNode root) {
    dive(root);
    System.out.println(root);
  }

  /**
   * решаем задачу через рекурсию, так как дерево балансированное
   * мы берем ноду, и рекурсивно выстраиваем ее левую ветвь в ряд, затем правую ветвь в ряд
   *
   * ПРИНЦИП - ВОЗВРАЩАЙ ХВОСТ
   * на выходе каждого погружения нам надо вернуть хвост лева и хвост права
   *
   * тут основная сложность заключается в том как достать этот самый хвост
   * а как его достать? ну надо скатится на самое дно епта и потом его возвращать паралельно
   * перестраивая ссылки
   */

  static TreeNode dive(TreeNode node) {
    if (node == null) {
      return null;
    }

    //если достигли дна, возвращаем элемент
    if (node.left == null && node.right == null) {
      return node;
    }

    //если не достигли ныряем
    TreeNode leftTail = dive(node.left);
    TreeNode rightTail = dive(node.right);

    if (leftTail != null) {
      //если левый хвост не пустой то приделываем к нему нашу текущую правую ноду
      leftTail.right = node.right;

      //а так же у нашей текущей ноды будет слева и справа ровные хвосты
      //значит нужно поменять левую на правую
      node.right = node.left;
      //ну и занулить левую
      node.left = null;
    }
    // по возможности всегда возвращаем правый хвост, если он пустой то левый
    // почему? да потому что правый блять будет всегда больше так как дерево балансированное
    return rightTail == null ? leftTail : rightTail;
  }
}
