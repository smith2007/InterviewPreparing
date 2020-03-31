package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

  public static void main(String[] args) {

  }

  /**
   * 286.MinimumCostToConnectSticks
   * <p>
   * https://leetcode.com/problems/minimum-cost-to-connect-sticks/ у нас есть палочки которые имеют
   * некоторую длинну длины каждой палки даны массиве чисел
   * <p>
   * мы можем соеденить две палки длинной X и Y в одну большую палку заплатив как бы цену X + Y мы
   * выполняем это действие до тех пор пока не останется одна палка
   * <p>
   * верни как бы минимальную цену соединения всех стиклв в одну большую таким образом
   * <p>
   * Таким образом, прежде чем любая работа будет сделана, у нас есть 3 стика, и 0 работа
   * завершена:
   * <p>
   * 0) палочки: [2, 4, 3], work == 0
   * <p>
   * 1) в первой итерации мы объединяем палки длиной 2 и 3 для рабочей нагрузки 5: палочки: [4, 5]
   * (потому что 2 + 3), work == 5
   * <p>
   * 2) Далее объединяем палочки 4 и 5. палочки: [9] (потому что 4 + 5) work == 9
   * <p>
   * Теперь, чтобы вычислить окончательный результат, суммируйте всю МИНИМАЛЬНУЮ РАБОТУ ВСЕХ ШАГОВ
   * <p>
   * работа 1 == 5 работа 2 == 9
   * <p>
   * результат = 9 + 5 == 14
   * <p>
   * Input: sticks = [2,4,3] Output: 14
   * <p>
   * если просят найти минимальную стоимость то надо всегда суммировать минимальные элементы суть
   * заключается в том что бы накладывать в PriorityQueue элементы затем извлекать по два элемента
   * складывать их опять в PriorityQueue и набивать глобальную сумму и так до тех пор пока не
   * достигнем пустой очереди
   */

  public int connectSticks(int[] sticks) {
    if (sticks.length == 1) {
      return 0;
    }

    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
    for (int s : sticks) {
      q.offer(s);

    }

    int sum = 0;
    while (q.size() > 1) {
      int s1 = q.poll();
      int s2 = q.poll();
      int subSum = s1 + s2;
      sum += subSum;
      q.offer(subSum);
    }

    return sum;
  }

}
