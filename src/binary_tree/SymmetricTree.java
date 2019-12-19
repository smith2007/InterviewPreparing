package binary_tree;

import java.util.LinkedList;

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

    static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isSameTree(root.left, root.right);
    }

    static boolean isSameTree(TreeNode first, TreeNode second) {

        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }


        LinkedList<TreeNode> firstQueue = new LinkedList<>();
        firstQueue.add(first);

        LinkedList<TreeNode> secondQueue = new LinkedList<>();
        secondQueue.add(second);

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {

            TreeNode firstElm = firstQueue.poll();
            TreeNode secondElm = secondQueue.poll();

            if (firstElm.val != secondElm.val) {
                return false;
            }

            if (firstElm.left != null && secondElm.left != null) {
                firstQueue.add(firstElm.left);
                secondQueue.add(secondElm.left);
            } else if (firstElm.left != null || secondElm.left != null) {
                return false;
            }


            if (firstElm.right != null && secondElm.right != null) {
                firstQueue.add(firstElm.right);
                secondQueue.add(secondElm.right);
            } else if (firstElm.right != null || secondElm.right != null) {
                return false;
            }
        }

        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }

}
