package data_structures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {

  public static void main(String[] args) {
    FindMedianfromDataStream findMedianfromDataStream = new FindMedianfromDataStream();

    findMedianfromDataStream.addNum(1);
    findMedianfromDataStream.addNum(2);
    //System.out.println(findMedianfromDataStream.findMedian());
    findMedianfromDataStream.addNum(3);

    System.out.println(findMedianfromDataStream.findMedian());
    /**
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     */
  }

  /**
   * initialize your data structure here.
   */

  PriorityQueue<Integer> reverseOrderHeap = new PriorityQueue<>(
      Comparator.reverseOrder()); // Smaller half.
  PriorityQueue<Integer> naturalOrderHeap = new PriorityQueue<>(
      Comparator.naturalOrder()); // Bigger half.

  public void addNum(int num) {

    reverseOrderHeap.add(num);
    naturalOrderHeap.add(reverseOrderHeap.poll());

    if (reverseOrderHeap.size() < naturalOrderHeap.size()) {
      reverseOrderHeap.add(naturalOrderHeap.poll());
    }
  }

  public double findMedian() {
    // Corner cases.
    if (reverseOrderHeap.isEmpty() && naturalOrderHeap.isEmpty()) {
      return 0.0;
    }

    if (reverseOrderHeap.size() == naturalOrderHeap.size()) {
      return (double) (reverseOrderHeap.peek() + naturalOrderHeap.peek()) / 2;
    } else {
      return reverseOrderHeap.peek();
    }
  }
}
