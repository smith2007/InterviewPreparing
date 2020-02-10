package binary_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BoundaryOfBinaryTree {

	public static void main(String[] args) {

		TreeNode root = StringToNodeBuilder.stringToTreeNode("[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]");
		boundaryOfBinaryTree(root).forEach(e -> System.out.print(e + " "));

	}

	static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Set<TreeNode> set = new HashSet<>();



		List<List<TreeNode>> levels = new ArrayList<>();

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			List<TreeNode> level = new ArrayList<>();
			while (size != 0) {
				TreeNode node = queue.poll();
				level.add(node);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size--;
			}

			levels.add(level);
		}

		List<Integer> leftPart = new ArrayList<>();
		//заполняем левую часть
		leftPart.add(root.val);
		set.add(root);
		if (root.left != null){
			for (int i = 1; i < levels.size(); i++) {
				TreeNode firstElm = levels.get(i).get(0);
				if (!set.contains(firstElm)) {
					set.add(firstElm);
					leftPart.add(firstElm.val);
				}
				if (firstElm.left == null && firstElm.right == null) {
					break;
				}
			}
		}

		List<Integer> rightPart = new ArrayList<>();
		if (root.right!=null){
			for (int i = levels.size() - 1; i >= 0; i--) {
				List<TreeNode> level = levels.get(i);
				TreeNode lastElm = level.get(level.size() - 1);
				if (!set.contains(lastElm)) {
					set.add(lastElm);
					rightPart.add(lastElm.val);
				}
			}
		}

		List<Integer> bottomPart = new ArrayList<>();
		for (int i = 0; i < levels.size(); i++) {
			List<TreeNode> level = levels.get(i);
			for (TreeNode node : level) {
				if (node.right == null && node.left == null && !set.contains(node)) {
					set.add(node);
					bottomPart.add(node.val);
				}
			}
		}

		leftPart.addAll(bottomPart);
		leftPart.addAll(rightPart);
		return leftPart;
	}
}
