package linkedlist.myown;

import java.util.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode first = new ListNode(2);

        ListNode second = new ListNode(4);

        ListNode third = new ListNode(3);


        first.setNext(second);
        second.setNext(third);

        ListNode first1 = new ListNode(5);

        ListNode second1 = new ListNode(6);

        ListNode third1 = new ListNode(4);


        first1.setNext(second1);
        second1.setNext(third1);

        ListNode listNode = addTwoNumbers(first, first1);

        System.out.println(listNode.val);


    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = null;
        ListNode res = cur;

        LinkedList<Pair> queue = new LinkedList<>();

        queue.push(new Pair(l1, l2));

        int ostatok = 0;
        int newVal = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.pop();
            if (pair.l1 != null && pair.l2 != null) {
                newVal = pair.l1.val + pair.l2.val + ostatok;
            } else if (pair.l1 != null && pair.l2 == null) {
                newVal = pair.l1.val + ostatok;
            } else if (pair.l1 == null && pair.l2 != null) {
                newVal = pair.l2.val + ostatok;
            }

            ostatok = 0;
            if (newVal > 9) {
                ostatok = newVal / 10;
                newVal = newVal % 10;
            }

            cur = new ListNode(newVal);

            if (res == null) {
                res = cur;
            }

            if (prev != null) {
                prev.next = cur;
            }

            prev = cur;

            if (pair.l1 != null && pair.l1.next != null && pair.l2 != null && pair.l2.next != null) {
                queue.push(new Pair(pair.l1.next, pair.l2.next));
            } else if (pair.l1 != null && pair.l1.next != null) {
                queue.push(new Pair(pair.l1.next, null));
            } else if (pair.l2 != null && pair.l2.next != null) {
                queue.push(new Pair(pair.l2.next, null));
            }
        }

        if (ostatok != 0) {
            cur = new ListNode(ostatok);
            prev.next = cur;
        }

        return res;
    }

    static class Pair {

        ListNode l1;
        ListNode l2;

        Pair(ListNode l1, ListNode l2) {
            this.l1 = l1;
            this.l2 = l2;
        }
    }
}
