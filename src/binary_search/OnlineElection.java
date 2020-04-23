package binary_search;

import java.util.Arrays;
import java.util.HashMap;

public class OnlineElection {


  int[] leadersAtEachStep;
  int[] times;

  public OnlineElection(int[] persons, int[] times) {
    this.times = times;

    //держим массив лидеров в каждое время
    leadersAtEachStep = new int[persons.length];

    //так же формируем такую кумулятивную мапу
    HashMap<Integer, Integer> countMap = new HashMap<>();

    //держим две переменных что бы понимать текущего лидера и его текущее кол-во голосов
    int highestCount = 0;
    int highestPerson = 0;

    for (int i = 0; i < persons.length; i++) {
      int key = persons[i];
      countMap.merge(key, 1, Integer::sum);

      //апдейтим если надо лидера
      if (countMap.get(key) >= highestCount) {
        highestCount = countMap.get(key);
        highestPerson = key;
      }
      //
      leadersAtEachStep[i] = highestPerson;
    }
  }

  public int q(int t) {
    //бинарный поиск тут
    int timePoint = Arrays.binarySearch(times, t);
    if (timePoint < 0) {
      return leadersAtEachStep[-timePoint - 2];
    }
    return leadersAtEachStep[timePoint];
  }
}