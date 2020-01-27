package binary_tree;

import java.util.concurrent.atomic.AtomicInteger;

public class RangeSumOfBST {

    public static void main(String[] args) {

        TreeNode root = StringToNodeBuilder.stringToTreeNode("[111,61,161,35,87,137,187,23,49,75,99,125,149,175,199,17,29,43,55,69,81,93,105,119,131,143,155,169,181,193,205,13,21,27,33,39,47,53,59,65,73,79,85,91,97,103,109,115,123,129,135,141,147,153,159,165,173,179,185,191,197,203,209,11,15,19,null,25,null,31,null,37,41,45,null,51,null,57,null,63,67,71,null,77,null,83,null,89,null,95,null,101,null,107,null,113,117,121,null,127,null,133,null,139,null,145,null,151,null,157,null,163,167,171,null,177,null,183,null,189,null,195,null,201,null,207]");

        System.out.println(rangeSumBST(root, 149, 155));

    }

    static int rangeSumBST(TreeNode root, int l, int r) {

        AtomicInteger sum = new AtomicInteger();

        dive(root, l, r, sum);

        return sum.intValue();


    }

    static void dive(TreeNode curr, int l, int r, AtomicInteger sum) {

        if (curr == null) {
            return;
        }

        if (curr.val >= l && curr.val <= r) {
            sum.addAndGet(curr.val);
        }

        if (curr.val > l) {
            dive(curr.left, l, r, sum);
        }
        if (curr.val < r) {
            dive(curr.right, l, r, sum);
        }
    }
}
