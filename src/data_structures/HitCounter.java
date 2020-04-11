package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HitCounter {

  /**
   * ["HitCounter","hit","hit","hit","getHits","hit","getHits","getHits"]
   * [[],[1],[2],[3],[4],[300],[300],[301]]
   *
   *
   * задизайни такую структуру которая будет считать все удары за последние 5 минут, каждый метод
   * принимает на вход timestamp В СЕКУНДАХ это как бы текущее время - эти таймстемпы постоянно
   * увеличиваются
   *
   * getHits(int timestamp) - верни все удары за последние 5 минут с учетом того что timestamp - это
   * текущее время
   *
   * я решил в тупую через динамический массив CopyOnWriteArrayList - метод hit(timestamp) тупо
   * кладет в массив метод getHitsCount(timestamp) вычисляет время на 5 минут назад (текущий
   * timeStamp - 300 sec) = border идем по массиву и берем все те хиты которые случились позднее
   * этого пятиминутного бордера
   */

  public static void main(String[] args) {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(2);
    hitCounter.hit(3);

    System.out.println(hitCounter.getHits(4));
    hitCounter.hit(300);
    System.out.println(hitCounter.getHits(300));

    System.out.println(hitCounter.getHits(301));
  }

  //делаем таймлайн
  private List<Integer> timeline = Collections.synchronizedList(new ArrayList<>());

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    timeline.add(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param currTimestamp - The current timestamp (in seconds granularity).
   *
   *
   */
  public int getHits(int currTimestamp) {
    int border = currTimestamp - 300;

    int count = 0;
    //идем с конца
    int i = timeline.size() - 1;
    for (; i >= 0; i--) {
        //доходим до границы в 5 минут
      if (timeline.get(i) > border) {
        count++;
      } else {
        break;
      }
    }
    if (++i > 0) {
      timeline = timeline.subList(i, timeline.size());
    }
    return count;
  }
}
