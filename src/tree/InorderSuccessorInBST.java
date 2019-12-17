package tree;

public class InorderSuccessorInBST {


    /**
     * дано бинарное дерево и какая-то нода, нода - число,
     * необходимо найти Successor - такую ноду которая будет
     * максимально большой к нашей ноде на входе
     */
    public static void main(String[] args) {
        TreeNode root = StringToNodeBuilder.stringToTreeNode("[5,3,6,2,4,null,null,1]");

        inorderSuccessor(root, new TreeNode(4));
    }

    static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null || p == null) {
            return null;
        }

        TreeNode lastLarger = null;

        TreeNode node = root;

        //идея очень простая
        //выполняем обход дерева
        //помни что надо найти - а найти надо элемент который
        //БОЛЬШЕ чем тот p который на входе
        while (node != null) {

            //если наш эл БОЛЬШЕ
            //тогда и только тогда мы его рассматриваем
            if (node.val > p.val) {
                lastLarger = node;
                node = node.left;
            } else {

                //если же элемент который мы рассматриваем меньше того что мы ищем
                //надо двигатся вправо
                node = node.right;
            }
        }

        return lastLarger;

    }
}
