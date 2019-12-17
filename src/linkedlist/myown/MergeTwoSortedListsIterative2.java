package linkedlist.myown;

public class MergeTwoSortedListsIterative2 {

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        first.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);

        ListNode res = merge(first, second);

        while (true) {
            System.out.println(res.getVal());

            if (res.next != null) {
                res = res.next;
            } else {
                break;
            }
        }
    }

    static ListNode merge(ListNode first, ListNode second) {

        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        ListNode newHead = null;
        if (first.val < second.val) {
            newHead = first;
            first = first.next;
        } else {
            newHead = second;
            second = second.next;
        }


        ListNode curr = newHead;

        while (true) {

            if (first == null) {
                curr.next = second;
                break;
            } else if (second == null) {
                curr.next = first;
                break;
            }

            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }


            curr = curr.next;


        }

        return newHead;
    }
}
