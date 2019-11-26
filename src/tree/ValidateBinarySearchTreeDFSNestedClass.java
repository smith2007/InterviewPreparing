package tree;

import java.util.LinkedList;
import java.util.Queue;


public class ValidateBinarySearchTreeDFSNestedClass {


    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[5,1,4,null,null,3,6]");

        System.out.println(isValidBST(root));
    }


    static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<Triple> stack = new LinkedList<>();
        stack.add(new Triple(root, Long.MIN_VALUE, Long.MAX_VALUE));


        while (!stack.isEmpty()) {

            Triple triple = stack.pop();

            TreeNode node = triple.node;
            if (node.val >= triple.max || node.val <= triple.min) {
                return false;
            }

            if (node.left != null) {
                stack.push(new Triple(node.left, triple.min, node.val));
            }
            if (node.right != null) {
                stack.push(new Triple(node.right, node.val, triple.max));
            }

        }
        return true;
    }

    static class Triple {
        TreeNode node;
        long min;
        long max;

        public Triple(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
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
