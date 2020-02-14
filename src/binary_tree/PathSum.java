package binary_tree;

public class PathSum {

	public static void main(String[] args) {

	}

	static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return dive(root, sum);
	}

	static boolean dive(TreeNode curr, int sum) {
		if (curr == null) {
			return false;
		}

		if (curr.right == null && curr.left == null && sum - curr.val == 0) {
			return true;
		}
		return dive(curr.left, sum - curr.val) || dive(curr.right, sum - curr.val);
	}
}
