package binary_tree;

import java.util.LinkedList;

public class MergeTwoBinaryTreesIterative {

	/**
	 * 172.MergeTwoBinaryTrees https://leetcode.com/problems/merge-two-binary-trees/
	 * <p>
	 * дано два бинарных дерева и представь что ты кладешь одно как бы на другое, некоторые ноды пересекаются, некоторые
	 * нет необходимо смержить эти два дерева в новое бинарное дерево. Правило мержа такое - если две ноды пересекаются
	 * - тогда просумируй значения нод в новое значение - в противном случае не нуловая нода будет использована как
	 * новая нода

	 */
	public static void main(String[] args) {

		TreeNode tree1 = StringToNodeBuilder.stringToTreeNode("[]");
		TreeNode tree2 = StringToNodeBuilder.stringToTreeNode("[1]");

		TreeNode treeNode = mergeTrees(tree1, tree2);
		//
	}

	static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) {
			return null;
		}

		LinkedList<TreeNode> q1 = new LinkedList<>();
		LinkedList<TreeNode> q2 = new LinkedList<>();
		t1 = t1 != null ? t1 : new TreeNode(0);
		t2 = t2 != null ? t2 : new TreeNode(0);
		q1.add(t1);
		q2.add(t2);
		while (!q1.isEmpty() || !q2.isEmpty()) {

			TreeNode elm1 = q1.poll();
			TreeNode elm2 = q2.poll();

			elm1.val = elm1.val + elm2.val;

			//надо положить в очередь сл ноды

			TreeNode left1 = elm1.left;
			TreeNode right1 = elm1.right;

			TreeNode left2 = elm2.left;
			TreeNode right2 = elm2.right;
			if (left1 == null && left2 == null && right1 == null && right2 == null) {
				continue;
			} else {
				if (left1 != null || left2 != null) {
					if (left1 == null) {
						left1 = new TreeNode(0);
						elm1.left = left1;
					}
					if (left2 == null) {
						left2 = new TreeNode(0);
						elm2.left = left2;
					}

					q1.add(left1);
					q2.add(left2);
				}

				if (right1 != null || right2 != null) {
					if (right1 == null) {
						right1 = new TreeNode(0);
						elm1.right = right1;
					}
					if (right2 == null) {
						right2 = new TreeNode(0);
						elm2.right = right2;
					}
					q1.add(right1);
					q2.add(right2);
				}
			}
		}
		return t1;
	}


}
