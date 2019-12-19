package binary_tree;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return whatIsYourMaxLevel(root,0);

    }

    // до какого уровня ты нырнул
    int whatIsYourMaxLevel(TreeNode node, int prev){

        int leftLevel = prev+1;
        int rightLevel = prev+1;

        if(node.left == null && node.right == null){
            return prev + 1;
        }

        if (node.left!=null) {
            leftLevel = whatIsYourMaxLevel(node.left, leftLevel);
        }

        if(node.right !=null){
            rightLevel = whatIsYourMaxLevel(node.right, rightLevel);
        }

        return Math.max(leftLevel,rightLevel);
    }
}
