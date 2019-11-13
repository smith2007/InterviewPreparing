package linkedlist.myown;

public class MergeTwoLinkedLists {


    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode curr = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);

        ListNode res = mergeTwoLists(first, second);

        while (true) {
            System.out.println(res.getVal());

            if (res.next != null) {
                res = res.next;
            } else {
                break;
            }
        }

    }

}
