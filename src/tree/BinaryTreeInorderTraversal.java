package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinaryTreeInorderTraversal {

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

        System.out.println(travers(root).stream().map(Objects::toString).collect(Collectors.joining(", ")));

    }

    static List<Integer> travers(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();

        /**
         * не надо блять пушить сразу рутовый элемент
         */
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            /**
             * опускаемся максимально глубоко
             * влево
             */
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //как только максимально глубоко влево упали
            //все достаем и распечатываем
            cur = stack.pop();
            res.add(cur.value);

            //какой блять следующий сука должен
            //быть элемент? конечно правый
            //по этому смело присваиваем
            cur = cur.right;

        }

        return res;
    }
}
