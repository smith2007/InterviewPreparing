package linkedlist.myown;

public class InsertIntoASortedCircularLinkedList {

  public static void main(String[] args) {

  }

  public Node insert(Node head, int insertVal) {
    if (head == null) {
      Node node = new Node(insertVal, null);
      node.next = node;
      return node;
    }
    Node curr = head;
    while (true) {
      //первый кейс - самый простой - текущее значение равно тому что вставляем - просто добавляем
      if (curr.val == insertVal

          //второй кейс текущий меньне, сл больше например 1 2 3 4 6 и надо вставить 5
          || (curr.val < insertVal && curr.next.val > insertVal)

          //третий кейс - начало цикла например например 4 2 3 и надо вставить 5
          || (curr.val > curr.next.val && insertVal > curr.val)

          //четвертый кейс - начало цикла например, но оба эл-та больше 4 2 3 надо вставить 1
          || (curr.val > curr.next.val && (insertVal < curr.val && insertVal < curr.next.val))

          //пятый кейс мы на грани возврата на сл head ноду снова 6 2 4 надо вставить 5
          || (curr.val > insertVal && curr.next.val > insertVal && curr.next == head)

          //шестой кейс мы на гране возврата но уже обе грани как бы меньше
          //то есть такой случай 1 1 1 и надо вставить 2
          || (curr.val < insertVal && curr.next.val < insertVal && curr.next == head)) {
        Node newNode = new Node(insertVal, null);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
      }
      curr = curr.next;
    }
  }

  static class Node {

    public int val;
    public Node next;

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }
}
