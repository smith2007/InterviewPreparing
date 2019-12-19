package binary_tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthSmallestElementInABSTHeap {


    public static void main(String[] args) {

    }

    static int kthSmallest(TreeNode root, int k) {
        if (root == null || k == 0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            pq.add(node.val);

            if (pq.size() > k) {
                pq.poll();
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        if (pq.size() == k) {
            return pq.poll();
        } else {
            return -1;
        }

    }
}
