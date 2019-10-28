package linkedlist.myown;

public class IsLinkedListLooped {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);

        ListNode second = new ListNode(2);

        ListNode third = new ListNode(3);

        ListNode fourth = new ListNode(4);

        ListNode fifth = new ListNode(5);

        first.setNext(second);
        second.setNext(third);

        third.setNext(fourth);

        fourth.setNext(fifth);

        fifth.setNext(third);

        System.out.println(is(first));

    }

    static boolean is(ListNode root) {

        ListNode first = root;
        ListNode second = root;
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
