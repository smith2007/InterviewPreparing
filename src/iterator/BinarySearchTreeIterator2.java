package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import binary_tree.TreeNode;

public class BinarySearchTreeIterator2 {

	private LinkedList<TreeNode> stack = new LinkedList<>();

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

		BinarySearchTreeIterator2 iterator = new BinarySearchTreeIterator2(root);
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

	public BinarySearchTreeIterator2(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null) {
				cur = cur.left;
			} else {
				break;
			}
		}

	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		// traversal right branch
		if(cur.right != null){
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				if(cur.left != null)
					cur = cur.left;
				else
					break;
			}
		}
		return node.val;	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !stack.isEmpty();
	}
}
