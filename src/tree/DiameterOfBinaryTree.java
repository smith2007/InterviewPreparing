package tree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode rootLeft = new TreeNode(2);

        TreeNode rootRight = new TreeNode(3);

        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(4);

        TreeNode rootLeftRight = new TreeNode(5);

        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        System.out.println(diameterOfBinaryTree(root));
    }

    /**
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     */
    static int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int diametr = dive(root.left, 0) + dive(root.right, 0);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(diametr,Math.max(left,right));
    }

    static int dive(TreeNode node, int currLevel) {

        if (node == null) {
            return currLevel;
        }

        return Math.max(dive(node.left, currLevel + 1), dive(node.right, currLevel + 1));
    }


}
