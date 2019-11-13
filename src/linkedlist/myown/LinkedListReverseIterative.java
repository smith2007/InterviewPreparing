package linkedlist.myown;

public class LinkedListReverseIterative {

    static ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        ListNode next = root.getNext();
        while (curr != null) {

            ListNode newPrev = curr;
            ListNode newCurr = next;

            ListNode newNext = next != null ? next.getNext() : null;

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


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        first.setNext(second);
        second.setNext(third);

        ListNode curr = first;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }


        System.out.println("------------");


        ListNode newRoot = reverse(first);

        curr = newRoot;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }


}
