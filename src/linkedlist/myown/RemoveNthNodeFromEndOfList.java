package linkedlist.myown;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        ListNode f = new ListNode(1);
        ListNode s = new ListNode(2);

        f.next = s;

        ListNode listNode = removeNthFromEnd(f, 2);
        System.out.println(listNode.val);
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode forward = head;
        ListNode nth = null;
        ListNode preNth = null;


        int count = 0;
        while (forward.next != null) {
            if (count + 1 == n) {
                nth = head;
            }


            if (nth != null) {
                preNth = nth;
                nth = nth.next;
            }
            forward = forward.next;
            count++;
        }

        if (count + 1 == n) {
            nth = head;
        }

        if (nth == null) {
            return null;
        }

        if (preNth == null && nth != null) {
            head = nth.next;
            return head;
        }

        if (nth != null && preNth != null) {
            preNth.next = nth.next;
        }
        return head;
    }
}
