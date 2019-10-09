package linkedlist.myown;

public class LinkedListReverse {

    public static void main(String[] args) {
        Node first = new Node(1);

        Node second = new Node(2);

        Node third = new Node(3);

        first.setNext(second);
        second.setNext(third);

        Node curr = first;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }


        System.out.println("------------");


        Node newRoot = reverse(first);

        curr = newRoot;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }


    static Node reverse(Node root) {

        Node prev = null;
        Node curr = root;
        Node next = root.getNext();

        while (curr != null) {

            Node newPrev = curr;
            Node newCurr = next;

            Node newNext = next != null ? next.getNext() : null;

            curr.setNext(prev);

            if (next != null) {
                next.setNext(curr);
            }


            prev = newPrev;
            curr = newCurr;
            next = newNext;

        }

        return prev;
    }
}
