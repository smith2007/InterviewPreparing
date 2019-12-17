package tree;

public class LowestCommonAncestorOfABinarySearchTreeIterative {


    public static void main(String[] args) {

    }

    /**
     * тут алгоритм очень прост - всего лишь надо найти точку пересечения двух нод
     * двигаемся влево или вправо в зависимости от того какой элемент перед нами
     *
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     */

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode curr = root;
        while (true) {
            if (curr.val > a.val && curr.val > b.val) {
                curr = curr.left;
            } else if (curr.val < a.val && curr.val < b.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
    }

}
