package binary_tree;

import java.util.LinkedList;
import java.util.Queue;


public class ValidateBinarySearchTreeDFS {


    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[10,5,15,null,null,6,20]");

        System.out.println(isValidBST(root));
    }


    static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);


        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (node.left != null) {
                if (node.left.val >= root.val) {
                    return false;
                }
                stack.push(node.left);
            }
            if (node.right != null) {
                if (node.right.val <= root.val) {
                    return false;
                }
                stack.push(node.right);
            }

        }
        return true;
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
