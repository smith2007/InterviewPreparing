package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = StringToNodeBuilder.stringToTreeNode("[3,9,20,null,null,15,7]");
        verticalOrder(root);
    }

    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        map.put(0, integers);

        dive(root.left, -1, map);
        dive(root.right, 1, map);

        for (Integer integer : map.keySet()) {
            res.add(map.get(integer));
        }
        return res;


    }

    static void dive(TreeNode curr, int vertical, Map<Integer, List<Integer>> map) {

        if (curr == null) {
            return;
        }

        dive(curr.left, vertical - 1, map);

        List<Integer> verticalArr = map.getOrDefault(vertical, new ArrayList<>());
        verticalArr.add(curr.val);
        map.put(vertical, verticalArr);

        dive(curr.right, vertical + 1, map);

    }
}
