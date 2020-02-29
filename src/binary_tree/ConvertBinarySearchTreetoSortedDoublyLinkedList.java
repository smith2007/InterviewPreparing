package binary_tree;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

	public static void main(String[] args) {
		ConvertBinarySearchTreetoSortedDoublyLinkedList ins = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
		TreeNode treeNode = ins.treeToDoublyList(StringToNodeBuilder.stringToTreeNode("[4,2,5,1,3]"));
		System.out.println(treeNode);
	}

	TreeNode newHead = null;
	TreeNode tail = null;

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return null;
		}
		dive(root, null);
		newHead.left = tail;
		tail.right = newHead;
		return newHead;
	}

	public TreeNode dive(TreeNode curr, TreeNode prev) {
		if (curr.left != null) {
			prev = dive(curr.left, prev);
		}
		TreeNode currRight = curr.right;
		curr.left = prev;
		if (prev!=null){
			prev.right = curr;
		}

		if (newHead == null){
			newHead = curr;
		}
		System.out.println(curr.val);
		if (currRight != null) {
			return dive(currRight, curr);
		}
		tail = curr;
		return curr;
	}


}
