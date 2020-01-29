package binary_tree;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode treeNode = StringToNodeBuilder.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
		System.out.println(maxPathSum(treeNode));
	}

	static int maxPathSum(TreeNode root) {
		AtomicInteger sum = new AtomicInteger(Integer.MIN_VALUE);
		dive(root, sum);
		return sum.get();
	}

	static int dive(TreeNode curr, AtomicInteger sum) {
		if (curr == null) {
			return 0;
		}
		//что выгоднее левая часть или правая часть
		//если они принесли отрицательное значение то их смотреть нет смысла
		//пусть будет ноль, что означает что это не будет частью нашей суммы
		int bestFromLeft = Math.max(dive(curr.left, sum), 0);
		int bestFromRight = Math.max(dive(curr.right, sum), 0);

		int prevSum = sum.get();
		int newSum = bestFromLeft + bestFromRight + curr.val;

		sum.set(Math.max(prevSum, newSum));
		//ну и вот она заветная коомбинация - возвращаем то что для нас лучше
		//левая часть плюс корень
		//либо правая часть плюс корень
		return Math.max(bestFromLeft, bestFromRight) + curr.val;
	}

}
