package linkedlist.myown;

public class ReverseLinkedListII {


  public static void main(String[] args) {

  }

  /**
   * как всегда - принцип окна - только сначала надо дойти до этого окна
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    //интеренсый трюк с фантомной нодой символизирующей head
    ListNode fakeHead = new ListNode(-1);
    //ну а дальше мы формируем окно prev и curr
    fakeHead.next = head;
    ListNode prev = fakeHead;
    ListNode curr = fakeHead.next;
    int i = 1;
    // находим нужную нам начальную точку
    while (i < m) {
      prev = curr;
      curr = curr.next;
      i++;
    }
    //и крутимся делаея своп
    ListNode node = prev;
    while (i <= n) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
      i++;
    }
    node.next.next = curr;
    node.next = prev;
    return fakeHead.next;
  }

}
