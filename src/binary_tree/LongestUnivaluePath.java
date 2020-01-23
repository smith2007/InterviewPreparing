package binary_tree;

public class LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode root = StringToNodeBuilder.stringToTreeNode("[1,4,5,4,4,5]");
		LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
		System.out.println(longestUnivaluePath.longestUnivaluePath(root));
	}

	public int longestUnivaluePath(TreeNode root) {
		if (root == null){
			return 0;
		}
		//что если рут будет как бы вершиной диаметра - какой будет максимальный путь?
		int diametr = dive(root.left, root, 0) + dive(root.right, root, 0);
		//а если левый узел будет вершиной диаметра - какая максимальная длинна пути будет
		int left = root.left == null ? 0 : longestUnivaluePath(root.left);
		//а если правый
		int right = root.right == null ? 0 : longestUnivaluePath(root.right);
		return Math.max(diametr, Math.max(left, right));
	}

	public int dive(TreeNode curr, TreeNode prev, int localLength) {
		if (curr == null) {
			return localLength;
		}
		if (prev != null && curr.val == prev.val) {
			int left = dive(curr.left, curr, localLength + 1);
			int right = dive(curr.right, curr, localLength + 1);
			return Math.max(left, right);
		} else {
			return localLength;
		}
	}


}
