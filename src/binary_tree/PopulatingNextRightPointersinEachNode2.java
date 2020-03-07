package binary_tree;

public class PopulatingNextRightPointersinEachNode2 {

    public static void main(String[] args) {

    }

    static Node connect(Node root) {
        if (root == null) {
            return null;
        }


        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }


    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}