package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dive(res, root, "");
        return res;
    }


    void dive(List<String> res, TreeNode curr, String currPath) {

        currPath += curr.val;

        if (curr.left == null && curr.right == null) {
            res.add(currPath);
            return;
        }
        if (curr.left != null) {
            dive(res, curr.left, currPath + "->");
        }
        if (curr.right != null) {
            dive(res, curr.right, currPath + "->");
        }
    }
}
