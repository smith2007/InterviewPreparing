package linkedlist.myown;

public class IntersectionofTwoLinkedLists {

  public static void main(String[] args) {

  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
      headA = headA.next;
      lenA--;
    }
    while (lenA < lenB) {
      headB = headB.next;
      lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  private int getLength(ListNode node) {
    int length = 0;
    while (node != null) {
      node = node.next;
      length++;
    }
    return length;
  }

}
