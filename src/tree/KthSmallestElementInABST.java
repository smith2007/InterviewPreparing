package tree;

import java.util.LinkedList;

public class KthSmallestElementInABST {


    public static void main(String[] args) {

    }

    static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            //максимально погружаемся влево
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();

            if (--k == 0){
                return root.val;
            }

            root = root.right;
        }

    }
}
