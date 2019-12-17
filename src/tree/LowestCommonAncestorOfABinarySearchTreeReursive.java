package tree;

public class LowestCommonAncestorOfABinarySearchTreeReursive {


    public static void main(String[] args) {

    }

    /**
     тут алгоритм очень прост - всего лишь надо найти точку пересечения двух нод

     https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     */

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = a.val;

        // Value of q;
        int qVal = b.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, a, b);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, a, b);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

}
