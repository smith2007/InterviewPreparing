package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewDFS {

	public static void main(String[] args) {
		TreeNode root = StringToNodeBuilder.stringToTreeNode("[1,2,3,null,5,null,4]");

		for (Integer integer : rightSideView(root)) {
			System.out.println(integer);
		}
	}

	static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		dive(root, result, 0);
		return result;
	}

	//идея в чем мы начинаем обходить наше дерево спускаясь изначально в правую часть!!!
	static void dive(TreeNode curr, List<Integer> result, int currDepth){
		if(curr == null){
			return;
		}
		//треккером наших краев будет размер нашего рез массива
		//если текущая глубина будет равна глубине нашего рез массива то сразу добавляем
		if(currDepth == result.size()){
			result.add(curr.val);
		}
		//еще раз. этот фокус работает только благодаря тому что
		//наш приоритет это всегда идти вправо
		dive(curr.right, result, currDepth + 1);
		dive(curr.left, result, currDepth + 1);
	}
}
