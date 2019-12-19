package binary_tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {

        /**
         * [1,2,3]
         * [3,2,1]
         */
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};

        TreeNode treeNode = build(preorder, inorder);
        System.out.println(treeNode);
/*
        int[] preorder1 = {3, 20, 15, 7};
        int[] inorder1 = {3, 15, 20, 7};

        TreeNode treeNode1 = build(preorder1, inorder1);
        System.out.println(treeNode1);


        int[] preorder2 = {3, 9, 10, 11, 20, 15, 7};
        int[] inorder2 = {10, 9, 11, 3, 15, 20, 7};

        TreeNode treeNode2 = build(preorder2, inorder2);
        System.out.println(treeNode2);*/
    }

    static TreeNode build(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, inorder, -1, inorder.length - 1);
    }

    static TreeNode build(int[] preorder, int preorderStart, int[] inorder, int inorderStart, int inorderEnd) {

        int rootVal = preorder[preorderStart];
        TreeNode treeNode = new TreeNode(rootVal);


        //если надо тогда надо посчитать границы этого треугольника
        //считаем i
        int i = inorderEnd;
        while (inorder[i] != preorder[preorderStart] && i > inorderStart + 1) {
            i--;
        }

        if (i == inorderStart + 1) {
            treeNode.left = null;
        } else {

            int mid = (inorderStart + i) / 2;
            int j = 0;
            for (; j < preorder.length; j++) {
                if (inorder[mid] == preorder[j]) {
                    break;
                }
            }

            treeNode.left = build(preorder, j, inorder, inorderStart, i - 1);
        }

        if (i == inorderEnd) {
            treeNode.right = null;
        } else {
            int mid = (i + inorderEnd + 1) / 2;
            int j = 0;
            for (; j < preorder.length; j++) {
                if (inorder[mid] == preorder[j]) {
                    break;
                }
            }
            treeNode.right = build(preorder, j, inorder, i, inorderEnd);

        }
        return treeNode;
    }
}
