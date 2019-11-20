package tree;

import java.util.LinkedList;

public class BinaryTreeBreathFirstTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        TreeNode rootLeft = new TreeNode(7);

        TreeNode rootRight = new TreeNode(9);

        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(11);

        TreeNode rootLeftRight = new TreeNode(13);

        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        TreeNode rootRightLeft = new TreeNode(19);
        TreeNode rootRightRight = new TreeNode(20);

        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;


        TreeNode rootLeftRightLeft = new TreeNode(15);
        TreeNode rootLeftRightRight = new TreeNode(17);

        rootLeftRight.left = rootLeftRightLeft;
        rootLeftRight.right = rootLeftRightRight;

        traverse(root);
    }


    static void traverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size != 0) {
                size--;
                TreeNode elm = queue.poll();
                if (elm == null) {
                    break;
                }
                System.out.print(elm.val + " ");

                if (elm.left != null) {
                    queue.add(elm.left);
                }

                if (elm.right != null) {
                    queue.add(elm.right);
                }
            }
            System.out.println();
        }

    }
}
