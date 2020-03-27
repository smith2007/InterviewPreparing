package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTreeZigzagLevelOrderTraversal {

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

        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }


    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.add(List.of(root.val));

        boolean isLeftNext = false;

        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {

            int[] floor = new int[queue.size()];

            int size = queue.size();

            int i = isLeftNext ? 0 : size - 1;

            while (size != 0) {
                TreeNode elm = queue.poll();
                floor[i] = elm.val;
                size--;
                if (elm.left != null) {
                    queue.add(elm.left);
                }
                if (elm.right != null) {
                    queue.add(elm.right);
                }

                i = isLeftNext ? i + 1 : i - 1;
            }

            isLeftNext = !isLeftNext;
            res.add(IntStream.of(floor).boxed().collect(Collectors.toList()));

        }

        return res;
    }
}
