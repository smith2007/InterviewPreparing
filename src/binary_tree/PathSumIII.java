package binary_tree;

public class PathSumIII {

    public static void main(String[] args) {
        TreeNode root = StringToNodeBuilder.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");

        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 8));
    }

    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return -1;
        }
        dive(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return res;

    }

    private void dive(TreeNode curr, int sum) {
        if (curr == null) {
            return ;
        }

        if (sum-curr.val == 0){
            res++;
        }
        dive(curr.left, sum-curr.val);
        dive(curr.right, sum-curr.val);
    }
}
