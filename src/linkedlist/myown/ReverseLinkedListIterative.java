package linkedlist.myown;

public class ReverseLinkedListIterative {

    static ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
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
