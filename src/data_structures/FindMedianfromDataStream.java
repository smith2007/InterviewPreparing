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
    findMedianfromDataStream.addNum(4);
    findMedianfromDataStream.addNum(5);
    findMedianfromDataStream.addNum(6);
    findMedianfromDataStream.addNum(7);
    findMedianfromDataStream.addNum(8);
    findMedianfromDataStream.addNum(9);
    findMedianfromDataStream.addNum(10);

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

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
      Comparator.reverseOrder()); // Smaller half он же maxHeap

  PriorityQueue<Integer> minHeap = new PriorityQueue<>(
      Comparator.naturalOrder()); // Bigger half он же minHeap

  public void addNum(int num) {
    //состав будет примерно вот такой
    //maxHeap: 5, 4, 2, 1, 3, minHeap: 6, 7, 9, 8, 10,
    //в одном хипе числа по убыванию - с большего по меньший
    //во втором хипе числа по возрастанию

    //итак порядок действий следующий
    //сначала новый элемент всегда добавляем в maxHeap
    // например у нас вот такой состав maxHeap: 5, 4, 3, 2, 1, minHeap: 6, 7, 9, 8, 10,
    //добаляем 11 -> получается 11 5 4 3 2 1
    maxHeap.add(num);
    //затем самый приоритетный, то есть наибольший переплывает в minHeap
    //minHeap = 6 7 8 9 10 11
    minHeap.add(maxHeap.poll());

    //так как размеры хипов не равны, то надо переложить в maxHeap то что
    //самый маленький элемент из minHeap
    //итого получается minHeap = 7 8 9 10 11
    //maxHeap = 6 5 4 3 2 1
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  //как теперь найти медиану
  //медиана зависит от кол-ва элементов в общем
  //идея такая что при не четном кол-ве элементов наш maxHeap всегда будет
  //содержать больше элементов чем minHeap
  //посмотри на пример с набором из 11:
  //minHeap = 7 8 9 10 11
  //maxHeap = 6 5 4  3  2  1
  //соотв для того что бы взять медиану надо всего лишь посмотреть
  //верхнее значение у minHeap
  //а вот если их длины р
  // авны - то берем топы у обоих хипов - складываем и делим пополам
  public double findMedian() {
    // Corner cases.
    if (maxHeap.isEmpty() && minHeap.isEmpty()) {
      return 0.0;
    }

    if (maxHeap.size() == minHeap.size()) {
      return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }
}
