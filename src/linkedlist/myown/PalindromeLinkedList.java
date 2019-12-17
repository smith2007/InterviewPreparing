package linkedlist.myown;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        ListNode n3 = new ListNode(3);

        ListNode no2 = new ListNode(2);
        ListNode no1 = new ListNode(1);

        n1.setNext(n2);
        n2.setNext(no2);

        //n3.setNext(no2);
        no2.setNext(no1);

        System.out.println(is(n1));
    }

    static boolean is(ListNode root) {
        ListNode slow = root;
        ListNode fast = root.getNext();

        boolean isOdd = false;

        while (true) {
            if (fast == null) {
                isOdd = true;
                break;
            } else if (fast.getNext() == null) {
                isOdd = false;
                break;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        ListNode prev = null;
        ListNode curr = isOdd ? slow : slow.getNext();
        ListNode next = slow.getNext();

        while (curr != null) {

            ListNode newPrev = curr;
            ListNode newCurr = next;

            ListNode newNext = next != null ? next.getNext() : null;

            curr.setNext(prev);

            if (next != null) {
                next.setNext(curr);
            }

            prev = newPrev;
            curr = newCurr;
            next = newNext;

        }



        ListNode left = root;
        ListNode right = prev;

        while (true) {
            if (!left.getVal().equals(right.getVal())) {
                return false;
            }
            left = left.getNext();
            right = right.getNext();

            if (left == null || right == null) {
                break;
            }

            if (left.equals(right)) {
                break;
            }
        }

        return true;

    }
}
