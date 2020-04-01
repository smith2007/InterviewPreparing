package binary_tree;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        TreeNode node;
        if (root.val > target) {
            node = root.left;
        } else {
            node = root.right;
        }

        if (node == null) {
            return root.val;
        }

        int value = closestValue(node, target);

        if (Math.abs(root.val - target) > Math.abs(value - target)) {
            return value;
        } else {
            return root.val;
        }
    }

}
