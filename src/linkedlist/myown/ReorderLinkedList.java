package linkedlist.myown;

import java.util.Stack;

public class ReorderLinkedList {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }


        int half = stack.size() / 2;
        curr = head;
        while (half != 0) {
            ListNode elm = stack.pop();
            ListNode next = curr.next;
            curr.next = elm;
            elm.next = next;
            curr = next;
            half--;
        }
        curr.next = null;

    }
}
