package binary_tree;

import java.util.Stack;

public class TwoSumIV {

    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int target) {
        Stack<TreeNode> leftStack = new Stack<>();  // стек 1 будет возвращать next smallest value
        Stack<TreeNode> rightStack = new Stack<>();  // стек 2 будет возвращать next largest value

        //пушим в левый и правые стеки через dfs
        for (TreeNode cur = root; cur != null; cur = cur.left) {
            leftStack.push(cur);
        }
        for (TreeNode cur = root; cur != null; cur = cur.right) {
            rightStack.push(cur);
        }

        while (leftStack.size() != 0 && rightStack.size() != 0 && leftStack.peek() != rightStack.peek()) {
            //берем и попарно смотрим на два верхних элемента в стеке
            int tempSum = leftStack.peek().val + rightStack.peek().val;

            //если в сумме дали target круто - возвращаем ее
            if (tempSum == target) {
                return true;
            } else if (tempSum < target) {
                //а вот если нет, если темповая сумма меньше - нам надо двигать левый указатель как
                //как его подвинуть в условиях ноды и дерева??
                //очевидно что надо взять теперь правую часть нашего попнутогоэлемента и нагрузить ее все левых ее брата
                for (TreeNode cur = leftStack.pop().right; cur != null; cur = cur.left) {
                    leftStack.push(cur);
                }
            } else {
                //тоже самое если в случае если сумма tempSum > target то есть много! надо уменьшать сумму двигаем правый указатель
                for (TreeNode cur = rightStack.pop().left; cur != null; cur = cur.right) {
                    rightStack.push(cur);
                }
            }
        }

        return false;
    }

}
