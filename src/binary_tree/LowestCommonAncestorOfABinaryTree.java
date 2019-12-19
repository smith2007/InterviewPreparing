package binary_tree;

public class LowestCommonAncestorOfABinaryTree {

    /**
     *
     дано бинарное дерево, обычное, не бинарное дерево поиска (по факту дан корень этого дерева)
     даны два узла - a b

     нужно найти наиболее общи потомок этих двух узлов

     два варианта решения:


     1 - с памятью, начинаем обход дерева и ищем наши искомые вершины используем два стека,
     в стеках фиксируем наш пройденный путь, как только элементы в стеках совпадут -
     первый совпавший элемент - и есть наш общий потомок

     2 - действуем рекурсией, обходим, левое правое поддерево,
     возвращаем ноду если и в левом и в правом поддереве есть оба наши искомых элемента,
     возвращаем левый потомок если в есть только в левом или правый потомок если только в левом

     сложность по времени: О(n)
     сложность по памяти: О(1)

     https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     *
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


        TreeNode result = find(root, 17, 11);
        System.out.println(result != null ? result.val : "null");

    }

    /**
     * тут надо крутится в цикле и возвращать сам поданный рут
     * тогда и только тогда когда либо  сам корень равен
     *
     * либо в и в левои и в правом поддереве есть искомые значения
     *
     */
    static TreeNode find(TreeNode node, int a, int b) {

        // частный случай, нода пуская
        if (node == null) {
            return null;
        }

        //какой либо из элементов равен текущей ноде
        //это нужно сделать для того что бы
        //потом ниже по коду обработать эту ситуацию
        if (node.val == a || node.val == b) {
            return node;
        } else {

            //если нет спускаемся ниже и проверяем
            //лево и правое поддерево
            TreeNode leftRes = find(node.left, a, b);
            TreeNode rightRes = find(node.right, a, b);

            //если и в левом и в правом поддереве есть
            //искомые элементы
            //все, вот оно наше искомое значение
            if (leftRes != null && rightRes != null) {
                //отдаем его
                return node;
            } else if (leftRes != null) {
                //если только левое поддереве содержит нужные нам элементы
                //отдаем его, значит блять текущий ListNode не является а является
                //носителем двух нод левое поддерево его и возвращаем
                return leftRes;
            } else if (rightRes != null) {
                //тоже самое но только с правым
                return rightRes;
            }
        }
        return null;
    }
}
