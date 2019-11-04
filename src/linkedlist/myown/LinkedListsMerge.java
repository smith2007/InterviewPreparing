package linkedlist.myown;

import java.util.PriorityQueue;

public class LinkedListsMerge {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode[] arr = {first, second, third};

        ListNode res = mergeKLists(arr);

        while (true) {
            System.out.println(res.getVal());

            if (res.next != null) {
                res = res.next;
            } else {
                break;
            }
        }

    }

    static ListNode mergeKLists(ListNode[] arr) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((e1, e2) -> e1.getVal().compareTo(e2.getVal()));

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        ListNode root = queue.poll();

        ListNode curr = root;

        while (!queue.isEmpty()) {
            ListNode elm = queue.poll();
            curr.next = elm;
            curr = curr.next;
            if (elm.next != null) {
                queue.add(elm.next);
            }
        }
        return root;
    }
}
