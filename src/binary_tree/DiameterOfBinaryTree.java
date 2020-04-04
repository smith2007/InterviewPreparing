package binary_tree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode rootLeft = new TreeNode(2);

        TreeNode rootRight = new TreeNode(3);

        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(4);

        TreeNode rootLeftRight = new TreeNode(5);

        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;


        System.out.println(diameterOfBinaryTree(root));
    }

    /**
     *  1
     * / \
     * 2   3
     * / \
     * 4   5
     */

    /**
     * РЕШАЕМ ПО ПРИНЦИПУ ДУГИ
     *
     * дано дерево надо найти как бы диаметр его ветвей - по сути макисимальную глубину слева и справа
     * <p>
     * надо решать через DFS и нырять на кажду ветвь и понимать какая максимальная глубина,
     * затем возвращать максимальный диаметр  через сумму левой и правой глубины    ans = Math.max(ans, L+R+1);
     * <p>
     * что такое диаметр - максимальная глубина слева
     * плюс максимальная глубина справа
     * <p>
     * int diametr = dive(root.left, 0) + dive(root.right, 0);
     * <p>
     * и самое хитрое надо понять что все таки выгоднее, включать текущую головную ноду
     * или не включать ее? может быть левое поддерево само собой содержит
     * максимальный диаметр??
     * для этой гипотезы мы рекурсивно так же вызываем наш основной метод на левом и правом поддереве
     * и смотрим что выгоднее
     * <p>
     * int left = diameterOfBinaryTree(root.left);
     * int right = diameterOfBinaryTree(root.right);
     * return Math.max(diametr,Math.max(left,right));
     */
    static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diametr = dive(root.left, 0) + dive(root.right, 0);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(diametr, Math.max(left, right));
    }

    static int dive(TreeNode node, int currLevel) {

        if (node == null) {
            return currLevel;
        }

        return Math.max(dive(node.left, currLevel + 1), dive(node.right, currLevel + 1));
    }


}
