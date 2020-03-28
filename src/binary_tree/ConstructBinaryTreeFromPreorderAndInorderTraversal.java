package binary_tree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public static void main(String[] args) {

    /**
     * [1,2,3] - preorder
     * [3,2,1] - inorder
     *
     */
    int[] preorder = {1, 2, 3};
    int[] inorder = {3, 2, 1};
    ConstructBinaryTreeFromPreorderAndInorderTraversal ins = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
    TreeNode treeNode = ins.buildTree(preorder, inorder);
    System.out.println(treeNode);

  }

    /**
     * [3,9,20,15,7] - preorder
     * [9,3,15,20,7] - inorder
     *

     * здесь надо работать через рекурсию и мапу индексов от inorder,
     * наш метод dive будет принимать на вход границы нашего дерева то есть нашего массива inorder,
     * смотри пример на картинку и на массивы - границы inorder для всего дерева 9 и 7 потом их голова это 3
     * трешка находится в preorder на 3 месте соотв надо
     *
     * 1 - подготовить мапу из значений inorder -> index
     * 2 - в методе dive работаем по границам из inorder - как найти рут в методе dive?
     * надо его взять из preOrder через глобальный каунтер
     * делаем глобальный каунтер в виде int preIdx = 0; - и будем каждый раз внутри рекурсии
     * его инкрементить что бы найти корректный рут
     *
     * 3-берем маппинг нашего рута в массиве inorder - тут то нам и понадобится наша мапа
     * 4-запускаем построение дерева левой и правой ее подчасти на обновленных границах
     */

    int preIdx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> indexInorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        //вот тут строим хэшмапу из значений -> на ее индекс
        int index = 0;
        for (Integer val : inorder){
            indexInorderMap.put(val, index++);
        }
        //и сваливаемся в рекурсию беря в расчет
        return dive(0, inorder.length);
    }


    public TreeNode dive(int inorderLeft, int inorderRight) {
        //если нет элементов для построение поддерева
        if (inorderLeft == inorderRight){
            return null;
        }

        //preorder - будет помогать нам строить рутовый элемент
        //берем preIndex - как рутовый элемент
        int rootVal = preorder[preIdx];

        //создаем его - рутовый элемент
        TreeNode root = new TreeNode(rootVal);

        //рутовый элемент как бы делит наш inorder list
        //на два поддерева - левый и правый
        //вот теперь самый ключевой момент - это взять
        //индекс рутового из preorder в inorder
        int rootIndexInInorder = indexInorderMap.get(rootVal);

        // рекурсия
        preIdx++;

        // билдим левое поддерево
        //при этом падаем в рексрию с двух границ левой краней гарницы и индекс того рутового в inorder
        root.left = dive(inorderLeft, rootIndexInInorder);
        // билдим правое поддерево
        root.right = dive(rootIndexInInorder + 1, inorderRight);
        return root;
    }


}
