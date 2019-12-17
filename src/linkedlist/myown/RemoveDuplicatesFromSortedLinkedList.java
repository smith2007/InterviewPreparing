package linkedlist.myown;

public class RemoveDuplicatesFromSortedLinkedList {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);

        ListNode second = new ListNode(2);

        ListNode third = new ListNode(3);

        ListNode fourth = new ListNode(4);

        ListNode fourth2 = new ListNode(4);

        ListNode fifth = new ListNode(5);

        first.setNext(second);

        second.setNext(third);

        third.setNext(fourth);

        fourth.setNext(fourth2);

        fourth2.setNext(fifth);

        ListNode node = deleteDuplicates(first);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode i = head;
        ListNode j = head;

        while (j != null) {
            if (!i.val.equals(j.val)) {
                i.next = j;
                i = j;
            }
            j = j.next;
        }
        return head;
    }
}
