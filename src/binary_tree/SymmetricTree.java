package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);

    TreeNode rootLeft = new TreeNode(3);

    TreeNode rootRight = new TreeNode(4);

    root.left = rootLeft;
    root.right = rootRight;

    TreeNode root2 = new TreeNode(2);

    TreeNode rootLeft2 = new TreeNode(3);

    TreeNode rootRight2 = new TreeNode(4);

    root2.left = rootLeft2;
    root2.right = rootRight2;

    TreeNode zero = new TreeNode(1);
    zero.left = root;
    zero.right = root2;

    System.out.println(isSymmetric(zero));
  }

  /**
   * дано дерево - надо понять его левое и правое поддерево симетричны ли
   * <p>
   * тупо идем бфс-ом через очередь сравниваем каждый из элементов, если симетричны - то деревья
   * равны, я сначало сделал через две очереди, клал в первую и во вторую, затем брал из них и
   * сравнивал
   * <p>
   * но можно сделать через одну очередь, и просто два раза вынимать из нее
   */

  static boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) {
            continue;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }

}
