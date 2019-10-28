package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinaryTreeSerializationDeserialization {


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

        System.out.println(serialize(root));

    }


    static String serialize(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                list.add(null);
                continue;
            }

            list.add(node.value);

            queue.add(node.left);
            queue.add(node.right);

        }

        return list.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    static TreeNode deserialize(String str) {

        return null;
    }
}
