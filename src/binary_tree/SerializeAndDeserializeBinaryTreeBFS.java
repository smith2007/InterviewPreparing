package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBinaryTreeBFS {


    /*

         5
       /   \
      7      9
     / \    /  \
    11 13  19   20
       / \
     15   17

     [5,7,9,11,13,19,20,null,null,15,17,null,null,null,null]
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

        String serialized = serialize(root);
        System.out.println(serialized);

        TreeNode result = deserialize(serialized);

        System.out.println(result);

    }

    /*
      1
     / \
    2   3
       / \
      4   5

    as "[1,2,3,null,null,4,5]"
         нулевой элемент всегда рут
         далее в зависимости от уровня
         у нас bfs-ом идет сначала два элемента
         потом 4 элемента массив
         затем следующий этаж 8 элементов

         если же нам встретился нуловый элемент
         то его тоже кладем в очередь, а вот его детей нет
     */

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

            list.add(node.val);
            queue.add(node.left);
            queue.add(node.right);

        }

        return list.stream().map(Objects::toString).collect(Collectors.joining(","));
    }

    static TreeNode deserialize(String str) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        String[] arr = str.split(",");


        LinkedList<Integer> queue = new LinkedList<>();
        for (String elm : arr) {
            queue.add(elm.equals("null") ? null : Integer.parseInt(elm));
        }

        LinkedList<TreeNode> temp = new LinkedList<>();
        TreeNode root = new TreeNode(queue.poll());
        temp.add(root);

        while (!queue.isEmpty()) {


            LinkedList<TreeNode> newTreeNodes = new LinkedList<>();
            while (!temp.isEmpty()) {
                TreeNode node = temp.poll();

                Integer leftInt = queue.poll();
                Integer rightInt = queue.poll();

                if (leftInt != null) {
                    node.left = new TreeNode(leftInt);
                    newTreeNodes.add(node.left);
                }
                if (rightInt != null) {
                    node.right = new TreeNode(rightInt);
                    newTreeNodes.add(node.right);
                }

            }

            temp.addAll(newTreeNodes);
        }

        return root;
    }
}
