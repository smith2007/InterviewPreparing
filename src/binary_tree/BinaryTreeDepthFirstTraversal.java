package binary_tree;

import java.util.LinkedList;

public class BinaryTreeDepthFirstTraversal {

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

        traverse(root);

    }

    /**
     * обход дерева в глубину - проще простого, надо всего лишь использовать стек
     * стек это стопка тарелок епта, сверху положил оттуда же и берешь
     *
     */
    static void traverse(TreeNode node) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.val);

            //кладем сначала правую ноду
            //в сл итерации снова правую положим уже дочерней ноды
            //ее же и извлекут первой
            //альтернативная ветка дерева не будет использована
            if (curr.right != null) {
                stack.push(curr.right);
            }

            //потом левую
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }
}
