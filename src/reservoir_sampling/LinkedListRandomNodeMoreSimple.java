package reservoir_sampling;

import java.util.Random;
import linkedlist.myown.ListNode;

public class LinkedListRandomNodeMoreSimple {

  int size = 0;
  Random r;
  ListNode p;

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
   *             contains at least one node.
   */
  public LinkedListRandomNodeMoreSimple(ListNode head) {
    r = new Random();
    p = head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      size++;
    }
    if (fast == null) {
      size = size * 2;
    } else {
      size = size * 2 + 1;
    }
  }

  /**
   * Returns a random node's value.
   */
  public int getRandom() {
    ListNode cur = p;
    int n = r.nextInt(size);
    for (int i = 0; i < n; i++) {
      cur = cur.next;
    }
    return cur.val;
  }
}
