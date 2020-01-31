package binary_tree;

import java.util.LinkedList;

public class MergeTwoBinaryTreesRecursive {

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
		if (t1 == null && t2 != null) {
			return t2;
		}
		if (t1 != null && t2 == null) {
			return t1;
		}

		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		t1.val += t2.val;
		return t1;
	}


}
