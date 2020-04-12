package binary_tree;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {


  /**
   * The the basic idea is to take the last element in postorder array as the root, find the
   * position of the root in the inorder array;
   *
   *
   * then locate the range for left sub-tree and right
   * sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.
   */
  private HashMap<Integer, Integer> inorderMap = new HashMap<>();
  private int[] postorder;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }
    this.postorder = postorder;
    //нагружаем мапу из эл inorder -> index inorder
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return buildTree(0, inorder.length - 1, 0,
        postorder.length - 1);
  }

  /**
   * надо понимать размеры окна в postorder и inorder
   */
  private TreeNode buildTree(int inorderStart, int inorderEnd,
      int postorderStart, int postorderEnd) {

    if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
      return null;
    }
    //ориентируемя на postorder - от него строим root
    //берем последний элемент в postorder - он и будет нашим рутом
    TreeNode root = new TreeNode(postorder[postorderEnd]);

    //находим индекс этого элемента в inorder
    int rootIndexInInorder = inorderMap.get(postorder[postorderEnd]);

    TreeNode leftChild = buildTree(inorderStart, rootIndexInInorder - 1, postorderStart,
        postorderStart + rootIndexInInorder - inorderStart - 1);

    TreeNode rightChild = buildTree(rootIndexInInorder + 1, inorderEnd,
        postorderStart + rootIndexInInorder - inorderStart, postorderEnd - 1);

    root.left = leftChild;
    root.right = rightChild;
    return root;
  }
}
