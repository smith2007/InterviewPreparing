package tree;

import java.util.LinkedList;

public class IsSameTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode rootLeft = new TreeNode(7);

        TreeNode rootRight = new TreeNode(9);

        root.left = rootLeft;
        root.right = rootRight;


        TreeNode root2 = new TreeNode(5);

        TreeNode rootLeft2 = new TreeNode(7);

        TreeNode rootRight2 = new TreeNode(9);

        root2.left = rootLeft2;
        root2.right = rootRight2;

        boolean sameTree = isSameTree(root, root2);

        System.out.println(sameTree);
    }

    static boolean isSameTree(TreeNode first, TreeNode second) {

        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }

        LinkedList<TreeNode> fq = new LinkedList<>();
        fq.add(first);

        LinkedList<TreeNode> sq = new LinkedList<>();
        sq.add(second);

        while (!fq.isEmpty() && !sq.isEmpty()) {
            TreeNode felm = fq.poll();
            TreeNode selm = sq.poll();

            if (felm.value != selm.value) {
                return false;
            }

            if (felm.left != null && selm.left != null) {
                fq.add(felm.left);
                sq.add(selm.left);
            } else if (felm.left != null || selm.left != null){
                return false;
            }

            if (felm.right != null && selm.right != null) {
                fq.add(felm.right);
                sq.add(selm.right);
            } else if (felm.right != null || selm.right != null) {
                return false;
            }
        }

        return fq.isEmpty() && sq.isEmpty();
    }

}
