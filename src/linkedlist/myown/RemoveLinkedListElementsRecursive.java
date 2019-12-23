package linkedlist.myown;

public class RemoveLinkedListElementsRecursive {

    public static void main(String[] args) {

    }

    ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }
}
