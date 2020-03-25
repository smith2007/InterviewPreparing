package binary_tree;

public class LowestCommonAncestorOfABinarySearchTreeIterative {


    public static void main(String[] args) {

    }

    /**
     * тут алгоритм очень прост - всего лишь надо найти точку пересечения двух нод
     * двигаемся влево или вправо в зависимости от того какой элемент перед нами
     *
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     */

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        //начинаем обход рутовой ноды
        TreeNode curr = root;
        //бесконечно крутимся в цикле
        while (true) {
            //надо понять куда дальше идти или это та самая нода что надо
            //если текущее значение больше чем наша первая И вторая нода
            //надо уменьшать ОНИ обе меньше епта
            //а в бинарном дереве поиска где меньшие элементы??
            //правильно левее - идем левее
            if (curr.val > first.val && curr.val > second.val) {
                curr = curr.left;
            } else if (curr.val < first.val && curr.val < second.val) { //вот тут обе больше - идем вправо
                curr = curr.right;
            } else {
                //ну а вот тут мы на развилке, кто-то из них меньше кто то больше
                //все - вот он общий предок
                return curr;
            }
        }
    }

}
