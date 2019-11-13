package linkedlist.myown;

public class ReverseLinkedListRecursive {

    ListNode newHead;

    ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        dive(head);
        return newHead;
    }

    ListNode dive(ListNode node) {
        if (node.next == null) {
            newHead = node;
            return node;
        } else {
            ListNode reversed = dive(node.next);
            node.next = null;
            reversed.next = node;
            return node;
        }
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

        ReverseLinkedListRecursive ins = new ReverseLinkedListRecursive();
        ListNode newRoot = ins.reverseList(first);

        curr = newRoot;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }


}
