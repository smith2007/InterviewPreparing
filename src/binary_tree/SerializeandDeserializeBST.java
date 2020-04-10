package binary_tree;

public class SerializeandDeserializeBST {


  public static void main(String[] args) {
    TreeNode root = StringToNodeBuilder.stringToTreeNode("[3,1,4,null,null,2]");

    SerializeandDeserializeBST ins = new SerializeandDeserializeBST();
    String serialize = ins.serialize(root);
    System.out.println(serialize);

    TreeNode deserialize = ins.deserialize(serialize);
    System.out.println(deserialize);

  }
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
    serializeDFS(root, sb);
    return sb.toString();
  }

  //обогощаем нашу sb
  //root left1 left2 leftX right1 right2 rightX
  //[3,1,4,null,null,2] - для такого дерева
  //получится вот так 3,1,4,2,
  private void serializeDFS(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val).append(",");
    serializeDFS(root.left, sb);
    serializeDFS(root.right, sb);
  }

  // Decodes your encoded data to tree.
  //самое интерсное происходит именно в десериализации
  public TreeNode deserialize(String strRepresentation) {
    String[] arr = strRepresentation.split(",");
    TreeNode root = null;
    for (String nodeValStr : arr) {
      if (nodeValStr.length() > 0) {
        root = deserializeDFS(root, Integer.parseInt(nodeValStr));
      }
    }
    return root;
  }

  public TreeNode deserializeDFS(TreeNode prevRoot, int nodeVal) {
    if (prevRoot == null) {
      return new TreeNode(nodeVal);
    }
    //если наша текущая новая как бы нода она меньше чем наша предыдущая рутовая
    //то надо присабачивать ее к левому потомку
    //иначе к правому
    if (nodeVal < prevRoot.val) {
      //падаем сюда передаем наш левый, он нулл, соотв кондишен на входе нам вернет
      prevRoot.left = deserializeDFS(prevRoot.left, nodeVal);
    } else {
      prevRoot.right = deserializeDFS(prevRoot.right, nodeVal);
    }
    return prevRoot;
  }

}
