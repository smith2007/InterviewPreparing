package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicateSubtrees {

  public static void main(String[] args) {
    TreeNode treeNode = StringToNodeBuilder.stringToTreeNode("[1,2,3,4,null,2,4,null,null,4]");

    FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
    findDuplicateSubtrees.findDuplicateSubtrees(treeNode);
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Integer> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    dive(root, map, set);
    return new ArrayList<>(set);
  }

  /**
   * решаем через dfs путем ныряния, на основе принципа что пусть мы будем составлять строку из тех
   * путей которые мы посетили
   * <p>
   * эта строка и будет нашим хешом
   */
  private String dive(TreeNode root, Map<String, Integer> map, Set<TreeNode> set) {
    if (root == null) {
      return "#";
    }
    // похоже на принцип дуги но под другим углом
    //мы строим рекурсивно нашу строку которую прошла ветвь
    //если какой-то из детей равне налл - мы ставим вместо него решетку
    String left = dive(root.left, map, set);
    String right = dive(root.right, map, set);
    String curr = root.val + left + right;

    if (map.containsKey(curr) && map.get(curr) == null) {
      set.add(root);
      map.put(curr, 1);
    } else if (!map.containsKey(curr)) {
      map.put(curr, null);
    }
    return curr;
  }

}
