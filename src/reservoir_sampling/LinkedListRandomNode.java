package reservoir_sampling;

import java.util.Random;
import linkedlist.myown.ListNode;

public class LinkedListRandomNode {

  ListNode head;
  Random rand;
  public LinkedListRandomNode(ListNode head) {
    rand = new Random();
    this.head = head;
  }

  public int getRandom() {
    ListNode cur = head;
    int count = 0;
    int res = 0;
    while(cur != null){
      int ran = rand.nextInt(count + 1);
      if(ran == count){
        res = cur.val;
      }
      count++;
      cur = cur.next;
    }

    return res;
  }

}
