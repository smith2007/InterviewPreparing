package binary_tree;

public class SerializeandDeserializeBST {

  /**
   * среиализуем через дфс через запяту/
   * сначала рут - затем левую ветвь
   * затем правую ветвь
   *
   *
   * десериализуем
   */
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    dfs(root, sb);
    return sb.toString();
  }

  private void dfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val).append(",");
    dfs(root.left, sb);
    dfs(root.right, sb);
  }

  // Decodes your encoded data to tree.
  //самое интерсное происходит именно в десериализации
  public TreeNode deserialize(String strRepresentation) {
    String[] arr = strRepresentation.split(",");
    TreeNode root = null;
    for (String nodeVal : arr) {
      if (nodeVal.length() > 0) {
        root = buildBST(root, Integer.parseInt(nodeVal));
      }
    }
    return root;
  }

  public TreeNode buildBST(TreeNode node, int nodeVal) {
    if (node == null) {
      return new TreeNode(nodeVal);
    }
    if (nodeVal < node.val) {
      node.left = buildBST(node.left, nodeVal);
    } else {
      node.right = buildBST(node.right, nodeVal);
    }
    return node;
  }

}
