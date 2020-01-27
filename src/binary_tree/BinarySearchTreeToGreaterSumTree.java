package binary_tree;

import java.util.LinkedList;

public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {

        TreeNode root = StringToNodeBuilder.stringToTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        bstToGst(root);

        System.out.println("s");
    }

    static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        //крутимся в цикле до тех пор пока либо текущая нода не будет пустой
        //либо стек не окажется пустым
        while (curr != null || !stack.isEmpty()) {
            //максимально опускаемся вправо
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }

        return root;

    }

}
