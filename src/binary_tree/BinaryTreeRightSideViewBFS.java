package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideViewBFS {

	public static void main(String[] args) {
		TreeNode root = StringToNodeBuilder.stringToTreeNode("[1,2,3,null,5,null,4]");

		for (Integer integer : rightSideView(root)) {
			System.out.println(integer);
		}
	}

	static List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}


		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			List<TreeNode> level = new ArrayList<>();
			int size = queue.size();
			while (size != 0) {
				TreeNode elm = queue.poll();
				level.add(elm);

				if (elm.left != null) {
					queue.add(elm.left);
				}

				if (elm.right != null) {
					queue.add(elm.right);
				}

				size--;
			}

			res.add(level.get(level.size() - 1).val);
		}
		return res;
	}
}
