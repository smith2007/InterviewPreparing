package linkedlist.myown;

public class SwapNodes {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);

        ListNode second = new ListNode(2);

        ListNode third = new ListNode(3);

        ListNode fourth = new ListNode(4);

        ListNode fifth = new ListNode(5);

        ListNode six = new ListNode(6);

        first.setNext(second);
        second.setNext(third);

        third.setNext(fourth);

        fourth.setNext(fifth);

        fifth.setNext(six);

        swapPairs(first);
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;

        ListNode newHead = second;

        ListNode prev = null;

        while (true) {

            if (first == null || second == null) {
                break;
            }

            ListNode newFirst = second.next;
            ListNode newSecond = second.next != null ? second.next.next : null;


            first.next = second.next;
            second.next = first;


            if (prev == null) {
                prev = first;
            } else {
                prev.next = second;
                prev = first;
            }
            first = newFirst;
            second = newSecond;

        }

        return newHead;
    }
}
