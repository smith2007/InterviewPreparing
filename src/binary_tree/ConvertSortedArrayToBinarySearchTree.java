package binary_tree;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

    }

    static TreeNode sortedArrayToBST(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        return construct(0, arr.length - 1, arr);
    }

    static TreeNode construct(int start, int end, int[] arr) {
        if (start > end) {
            return null;
        }
        int midIndex = (start + end) / 2;
        int mid = arr[midIndex];

        TreeNode node = new TreeNode(mid);

        node.right = construct(midIndex + 1, end, arr);
        node.left = construct(start, midIndex - 1, arr);

        return node;
    }


}
