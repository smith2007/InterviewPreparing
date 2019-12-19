package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    /**
     *Дано бинарное дерево (в виде рут ноды)
     * - необходимо вывести массив массивов из нод, находящихся на каждом из этажей этого дерева
     *
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
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

        List<List<TreeNode>> lists = find(root);

        System.out.println(lists);

    }


    static List<List<TreeNode>> find(TreeNode root) {
        ArrayList<List<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<TreeNode> floor = new ArrayList<>();

            int phantomQueueSize = queue.size();

            while (phantomQueueSize != 0) {
                TreeNode elm = queue.poll();
                if (elm == null) {
                    break;
                }

                floor.add(elm);

                if (elm.left != null) {
                    queue.add(elm.left);

                }
                if (elm.right != null) {
                    queue.add(elm.right);
                }
                phantomQueueSize--;
            }

            result.add(floor);
        }

        return result;
    }
}
