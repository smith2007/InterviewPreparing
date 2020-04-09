package binary_tree;

public class LowestCommonAncestorofDeepestLeaves {

    public static void main(String[] args) {

    }

    int maxDepth = 0;
    TreeNode lowestCommonAncestor;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dive(root, 0);
        return lowestCommonAncestor;
    }


    /**
     * очень крутая идея, даже если у нас один будет элемент который самый губокий - все равно запускаем на нем
     * рекурсивный вызов - он и будет тем потомком
     *
     *
     задача решается через дфс рекурсией, запускаем на каждой ноде и спрашиваем какая макисмальная глубина у твоей ветки?
     она одинаковая с твоим братом? если да сохраняем

     а так как мы рекусией спускаемся все ниже и ниже то вот он и получается ловест
     */
    private int dive(TreeNode node, int currDepth) {
        maxDepth = Math.max(maxDepth, currDepth);
        if (node == null) {
            return currDepth;
        }
        //ныряем да и все, смотрим что они нам принесут
        int left = dive(node.left, currDepth + 1);
        int right = dive(node.right, currDepth + 1);
        if (left == maxDepth && right == maxDepth) {
            lowestCommonAncestor = node;
        }
        return Math.max(left, right);
    }
}
