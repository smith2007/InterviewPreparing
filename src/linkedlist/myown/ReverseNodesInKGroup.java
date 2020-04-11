package linkedlist.myown;

public class ReverseNodesInKGroup {


  /**
   * тут действуем двумя указателями - окном -
   * и будем свопать элементы как только мы достигли размера окна кратно K
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode begin;
    if (head == null || head.next == null || k == 1) {
      return head;
    }
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    begin = dummyhead;
    int i = 0;
    while (head != null) {
      i++;
      //как только наш указатель кратен k
      //это повод что бы ревертуть
      if (i % k == 0) {
        begin = reverse(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }
    }
    return dummyhead.next;

  }

  public ListNode reverse(ListNode begin, ListNode end) {
    ListNode curr = begin.next;
    ListNode next, first;
    ListNode prev = begin;
    first = curr;
    while (curr != end) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    begin.next = prev;
    first.next = curr;
    return first;
  }

}