package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIsBalanced {

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


    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}
