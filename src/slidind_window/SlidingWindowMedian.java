package slidind_window;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

  public static void main(String[] args) {

  }

  /**
   *
   тут задача решается с помощью двух куч - PriorityQueue - reverseOrderHeap и naturalOrderHeap, они же maxHeap и minHeap

   идея заключается как бы вот в чем - если нам надо быстро иметь доступ к середине нашего листа, давай его хранить на стыке, по двум половинкам!

   первую часть и вторую сортированную - нам тут идеально подходит куча, ее можно очень удобно использовать для того что бы можно было хранить две половинки в отсортированном порядке, но тут очень хитро надо держать в уме стратегию, как правильно оркестрировать этими кучами

   add 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 in the order:
   maxHeap: 1, minHeap:
   maxHeap: 1, minHeap: 2,
   maxHeap: 2, 1, minHeap: 3,
   maxHeap: 2, 1, minHeap: 3, 4,
   maxHeap: 3, 1, 2, minHeap: 4, 5,
   maxHeap: 3, 1, 2, minHeap: 4, 5, 6,
   maxHeap: 4, 3, 2, 1, minHeap: 5, 7, 6,
   maxHeap: 4, 3, 2, 1, minHeap: 5, 7, 6, 8,
   maxHeap: 5, 4, 2, 1, 3, minHeap: 6, 7, 9, 8,
   maxHeap: 5, 4, 2, 1, 3, minHeap: 6, 7, 9, 8, 10,


   итак порядок добавления элементов  следующий
   1 - сначала новый элемент всегда добавляем в maxHeap, например у нас вот такой состав maxHeap: 5, 4, 3, 2, 1, minHeap: 6, 7, 9, 8, 10,
   добаляем 11 -> получается maxHeap 11 5 4 3 2 1

   2 - затем самый приоритетный, то есть наибольший переплывает в minHeap
   minHeap = 6 7 8 9 10 11

   3 - так как размеры хипов не равны, то надо переложить в maxHeap то что, самый маленький элемент из minHeap
   итого получается minHeap = 7 8 9 10 11
   maxHeap = 6 5 4 3 2 1

   как теперь найти медиану??
   медиана зависит от кол-ва элементов в общем
   идея такая что при не четном кол-ве элементов наш maxHeap всегда будет
   содержать больше элементов чем minHeap
   посмотри на пример с набором из 11:
   minHeap = 7 8 9 10 11
   maxHeap = 6 5 4  3  2  1
   соотв для того что бы взять медиану надо всего лишь посмотреть
   верхнее значение у minHeap
   а вот если их длины равны - то берем топы у обоих хипов - складываем и делим пополам
   */
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

  public double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length - k + 1;
    if (n <= 0) {
      return new double[0];
    }
    double[] result = new double[n];

    for (int i = 0; i <= nums.length; i++) {
      if (i >= k) {
        result[i - k] = getMedian();
        remove(nums[i - k]);
      }
      if (i < nums.length) {
        add(nums[i]);
      }
    }

    return result;
  }

  private void add(int num) {

    //состав будет примерно вот такой
    //maxHeap: 5, 4, 2, 1, 3, minHeap: 6, 7, 9, 8, 10,
    //в одном хипе числа по убыванию - с большего по меньший
    //во втором хипе числа по возрастанию

    //итак порядок действий следующий
    //сначала новый элемент всегда добавляем в maxHeap
    // например у нас вот такой состав maxHeap: 5, 4, 3, 2, 1, minHeap: 6, 7, 9, 8, 10,
    //добаляем 11 -> получается 11 5 4 3 2 1

    if (num < getMedian()) {
      maxHeap.add(num);
    }
    else {
      minHeap.add(num);
    }

    //затем самый приоритетный, то есть наибольший переплывает в minHeap
    //minHeap = 6 7 8 9 10 11

    //так как размеры хипов не равны, то надо переложить в maxHeap то что
    //самый маленький элемент из minHeap
    //итого получается minHeap = 7 8 9 10 11
    //maxHeap = 6 5 4 3 2 1
    if (maxHeap.size() > minHeap.size()) {
      minHeap.add(maxHeap.poll());
    }
    if (minHeap.size() - maxHeap.size() > 1) {
      maxHeap.add(minHeap.poll());
    }
  }

  private void remove(int num) {
    if (num < getMedian()) {
      maxHeap.remove(num);
    } else {
      minHeap.remove(num);
    }
    if (maxHeap.size() > minHeap.size()) {
      minHeap.add(maxHeap.poll());
    }
    if (minHeap.size() - maxHeap.size() > 1) {
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
  private double getMedian() {
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
