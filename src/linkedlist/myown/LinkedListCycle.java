package linkedlist.myown;

public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode first = new ListNode(1);

    ListNode second = new ListNode(2);

    ListNode third = new ListNode(3);

    ListNode fourth = new ListNode(4);

    ListNode fifth = new ListNode(5);

    first.setNext(second);
    second.setNext(third);

    third.setNext(fourth);

    fourth.setNext(fifth);

    fifth.setNext(third);

    System.out.println(hasCycle(first));

  }

  static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (true) {

      if (slow == fast) {
        return true;
      }
      if (fast == null || fast.next == null) {
        return false;
      }

      slow = slow.next;
      fast = fast.next.next;
    }
  }
}
