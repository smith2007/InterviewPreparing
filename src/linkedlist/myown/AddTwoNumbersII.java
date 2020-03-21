package linkedlist.myown;

import java.util.Stack;

public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode f1 = new ListNode(7);
        ListNode f2 = new ListNode(2);
        f1.next = f2;
        ListNode f3 = new ListNode(4);
        f2.next = f3;
        ListNode f4 = new ListNode(3);
        f3.next = f4;

        ListNode s1 = new ListNode(5);
        ListNode s2 = new ListNode(6);
        s1.next = s2;
        ListNode s3 = new ListNode(4);
        s3.next = s2;

        AddTwoNumbersII numbersII = new AddTwoNumbersII();
        ListNode listNode = numbersII.addTwoNumbers(f1, s1);
        System.out.println(listNode.val);

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                sum += s1.pop();
            }
            if (!s2.empty()) {
                sum += s2.pop();
            }
            list.val = sum % 10;

            ListNode head = new ListNode(sum / 10);

            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }

}
