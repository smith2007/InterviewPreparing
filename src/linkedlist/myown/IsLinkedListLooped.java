package linkedlist.myown;

public class IsLinkedListLooped {

    public static void main(String[] args) {
        Node first = new Node(1);

        Node second = new Node(2);

        Node third = new Node(3);

        Node fourth = new Node(4);

        Node fifth = new Node(5);

        first.setNext(second);
        second.setNext(third);

        third.setNext(fourth);

        fourth.setNext(fifth);

        fifth.setNext(third);

        System.out.println(is(first));

    }

    static boolean is(Node root) {

        Node first = root;
        Node second = root;
        while (true) {
            first = first.getNext();
            second = second.getNext();
            if (second == null) {
                break;
            } else {
                second = second.getNext();
            }

            if (first.equals(second)) {
                return true;
            }

        }
        return false;
    }
}
