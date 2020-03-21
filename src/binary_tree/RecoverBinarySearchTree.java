package binary_tree;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node = StringToNodeBuilder.stringToTreeNode("[3,1,4,null,null,2]");
        RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
        tree.recoverTree(node);
    }

    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;

    /**
     * идея в чем - мы таскаем с собой всегда предыдущий элемент
     * <p>
     * и ищем два отклонения от предыдущего элемента, запоминаем их в виде first и second
     * <p>
     * далее мы должны в конце просто свопнуть два этих откланения
     */
    public void recoverTree(TreeNode root) {
        // In order traversal to find the two elements
        dive(root);

        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    //постоянно трекаем предыдущий элемент
    private void dive(TreeNode curr) {

        if (curr == null) {
            return;
        }

        dive(curr.left);

        if (curr.val < prevElement.val) {
            if (first != null) {
                second = curr;
            } else {
                first = prevElement;
                second = curr;
            }
        }

        prevElement = curr;

        dive(curr.right);
    }
}
