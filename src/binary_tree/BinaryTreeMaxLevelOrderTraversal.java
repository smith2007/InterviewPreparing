package binary_tree;

import java.util.LinkedList;

public class BinaryTreeMaxLevelOrderTraversal {

    /**
     * задача с appZen
     * <p>
     * дано бинарное дерево, необходимо сделать
     * levelOrder traversal c максимумом для каждой пары
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode rootLeft = new TreeNode(7);

        TreeNode rootRight = new TreeNode(9);

        root.left = rootLeft;
        root.right = rootRight;


        TreeNode rootLeftLeft = new TreeNode(11);

        TreeNode rootLeftRight = new TreeNode(13);

        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        TreeNode rootRightLeft = new TreeNode(19);
        TreeNode rootRightRight = new TreeNode(20);

        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;


        TreeNode rootLeftRightLeft = new TreeNode(15);
        TreeNode rootLeftRightRight = new TreeNode(17);

        rootLeftRight.left = rootLeftRightLeft;
        rootLeftRight.right = rootLeftRightRight;

        bfs(root);

    }


    static void bfs(TreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            while (levelSize != 0) {

                TreeNode elm1 = queue.poll();
                TreeNode elm2 = queue.poll();

                if (elm1 != null && elm2 != null) {
                    System.out.print(Math.max(elm1.val, elm2.val) + " ");
                    queue.add(elm2.right);
                    queue.add(elm2.left);
                    queue.add(elm1.right);
                    queue.add(elm1.left);
                } else if (elm1 != null) {
                    System.out.print(elm1.val + " ");
                    queue.add(elm1.right);
                    queue.add(elm1.left);
                } else if (elm2 != null) {
                    System.out.print(elm2.val + " ");
                    queue.add(elm2.right);
                    queue.add(elm2.left);
                }

                levelSize -= 2;

            }
            System.out.println();
        }
    }
}
