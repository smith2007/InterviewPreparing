package iterator;

import binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeIterator {



	/**
	 * 160.BinarySearchTreeIterator
	 * https://leetcode.com/problems/binary-search-tree-iterator/
	 *
	 * необходимо имплементировать итератор бинарного дерева поиска, этот итератор будет инициализирован рутовой нодой дерева
	 * метод next должен возвращать следующий НАИМЕНЬШИЙ элемент в бинарном дереве
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		TreeNode rootLeft = new TreeNode(7);

		TreeNode rootRight = new TreeNode(9);

		root.left = rootLeft;
		root.right = rootRight;

		TreeNode rootLeftLeft = new TreeNode(11);

		TreeNode rootLeftRight = new TreeNode(13);

		rootLeft.left = rootLeftLeft;
		rootLeft.right = rootLeftRight;


		TreeNode rootRightLeft = new TreeNode(19);
		TreeNode rootRightRight = new TreeNode(20);

		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;


		TreeNode rootLeftRightLeft = new TreeNode(15);
		TreeNode rootLeftRightRight = new TreeNode(17);

		rootLeftRight.left = rootLeftRightLeft;
		rootLeftRight.right = rootLeftRightRight;

		BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.next());

	}

	private List<Integer> list = new ArrayList<>();
	private Iterator<Integer> iterator = list.iterator();
	/**
	 * этот вариант решается за дфс inorder traversal
	 * накладываем элементы в лист и траверсим
	 */
	public BinarySearchTreeIterator(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;

		}
		this.iterator = list.iterator();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		return iterator.next();
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return iterator.hasNext();
	}
}
