package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {

    public static void main(String[] args) {

    }

    /**
     * мы идем бфс ом
     * если у ноды есть и и правый и левый - все окей
     *
     * если левый пустой а правый не пустой не окей
     *
     * если
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                if (node.right != null) {
                    return false;
                }
                break;
            }
            queue.offer(node.left);
            //если правый равен нулю - все это повод к тому что надо допроверить
            //ниже добавленные ноды они ОБЯЗАНЫ БЫТЬ ПУСТЫЕ БЕЗ ДЕТЕЙ
            if (node.right == null){
                break;
            }
            queue.offer(node.right);
        }

        while (!queue.isEmpty()) {
            //если и левый ИЛИ правый пустой
            //значит это не валидное дерево
            //ниже добавленные ноды они ОБЯЗАНЫ БЫТЬ ПУСТЫЕ БЕЗ ДЕТЕЙ
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null) {
                return false;
            }

        }
        return true;
    }
}
