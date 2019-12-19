package binary_tree;

import static binary_tree.StringToNodeBuilder.stringToTreeNode;

public class BalancedBinaryTree {

    /**
     * dfs
     *https://leetcode.com/problems/balanced-binary-tree/
     */
    public static void main(String[] args) {

        TreeNode root = stringToTreeNode("[3,9,20,null,null,15,7]\n");
        System.out.println(isBalanced(root));

    }

    static boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }


        int leftLevel = 1;
        int rightLevel = 1;

        if (node.left != null) {
            leftLevel = whatIsYourMaxLevel(node.left, leftLevel);
        }

        if (node.right != null) {
            rightLevel = whatIsYourMaxLevel(node.right, rightLevel);
        }

        if (leftLevel == Integer.MAX_VALUE || rightLevel == Integer.MAX_VALUE) {
            return false;
        }

        return Math.abs(rightLevel - leftLevel) <= 1;
    }


    // до какого уровня ты нырнул
    static int whatIsYourMaxLevel(TreeNode node, int prev) {

        int leftLevel = prev + 1;
        int rightLevel = prev + 1;

        if (node.left == null && node.right == null) {
            return prev + 1;
        }

        if (node.left != null) {
            leftLevel = whatIsYourMaxLevel(node.left, leftLevel);
        }

        if (node.right != null) {
            rightLevel = whatIsYourMaxLevel(node.right, rightLevel);
        }

        if (Math.abs(rightLevel - leftLevel) > 1) {
            return Integer.MAX_VALUE;
        }
        return Math.max(leftLevel, rightLevel);
    }


}
