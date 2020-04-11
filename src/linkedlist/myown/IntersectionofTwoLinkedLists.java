package linkedlist.myown;

public class IntersectionofTwoLinkedLists {

  public static void main(String[] args) {

  }

  /**
   * можно пробежать по обоим листам, выяснитьь их длины, понять кто длинее, и затем второй как бы
   * проход обходить и начинать сканировать с самого длинного, а не достающий заполнять нулем, как
   * только оба не нулы начинаем попарное сканикрование, как только нада из а equals b - вот оно
   * наше пересечение

   */
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
