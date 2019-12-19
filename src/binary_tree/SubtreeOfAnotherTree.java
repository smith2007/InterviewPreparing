package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

        /**
         * [3,4,5,1,2]
         * [4,1,2]
         */
        TreeNode s = StringToNodeBuilder.stringToTreeNode("[1,1]");
        TreeNode t = StringToNodeBuilder.stringToTreeNode("[1]");

        System.out.println(isSubtree(s, t));

    }

    static boolean isSubtree(TreeNode s, TreeNode t) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = s;
        queue.add(p);

        while (!queue.isEmpty()) {
            p = queue.poll();

            if (p.val == t.val) {

                TreeNode elm1 = p;
                TreeNode elm2 = t;
                
                Queue<TreeNode> queue1 = new LinkedList<>();
                Queue<TreeNode> queue2 = new LinkedList<>();
                
                queue1.add(elm1);
                queue2.add(elm2);
                
                while (elm1.val == elm2.val && !queue1.isEmpty() && !queue2.isEmpty()) {
                    elm1 = queue1.poll();
                    elm2 = queue2.poll();
                    if (elm1.left != null){
                        queue1.add(elm1.left);
                    }
                    if (elm1.right != null){
                        queue1.add(elm1.right);
                    }
                    if (elm2.left != null){
                        queue2.add(elm2.left);
                    }
                    if (elm2.right != null){
                        queue2.add(elm2.right);
                    }
                }
                if (elm1.val == elm2.val && queue1.isEmpty() && queue2.isEmpty()){
                    return true;//a match is found till leaf
                }


            }

            if (p.left != null){
                queue.add(p.left);
            }
            if (p.right != null){
                queue.add(p.right);
            }
        }
        return false;
    }
}

