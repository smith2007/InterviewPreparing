package linkedlist.myown;

public class MergeTwoSortedListsIterative {

    /**
     * дан два не пустых линкед листа которые представляют собой как бы два числа
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * необходимо сложить их
     *
     * ну тут я как делал, ходим по каждому из листов паралельно и создаем пару,
     * можно отдельный класс для этого завести, ну что пытаемся сложить, паралельно
     * понимаем результат сложения у нас с остатком или без
     * как проверить
     *
     *     ostatok = 0;
     *             if (newVal > 9) {
     *                 ostatok = newVal / 10;
     *                 newVal = newVal % 10;
     *             }
     *
     * тогда держим это в уме
     */

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
