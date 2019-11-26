package tree;

import java.util.LinkedList;
import java.util.Queue;


public class ValidateBinarySearchTreeRecursive {


    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[5,1,4,null,null,3,6]");

        System.out.println(isValidBST(root));
    }


    static boolean isValidBST(TreeNode node) {
        return dive(node, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    static boolean dive(TreeNode node, long maxValue, long minValue) {
        if (node == null) {
            return true;
        }
        if (node.val >= maxValue || node.val <= minValue) {
            return false;
        }
        return dive(node.left, node.val, minValue) && dive(node.right, maxValue, node.val);
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
