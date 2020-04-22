package array;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

  /**
   * Brute Force In the brute force solution, we consider every possible subsequence that can be
   * formed using the elements of the given array
   * <p>
   * If the difference between the maximum and the minimum values obtained is 1, it means the
   * current subsequence forms a harmonious subsequence. Thus, we can consider the number of
   * elements in this subsequence to be compared with the length of the last longest harmonious
   * subsequence.
   */

  /**
   * The idea is to keep a count of all the numbers, and eventually for each of the numbers,
   * check if there's any adjacent number. If it's present, then add the count
   * of both - since these two numbers form subsequence in the array.
   */
  public int findLHS(int[] nums) {

    //набиваем каунтер
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    int result = 0;
    //бежим по ключам - то есть уникальным значениям массива
    for (int key : map.keySet()) {
      //если наш массив содержит теоретический максимум
      //значит можно рассмотреть это как сабсиквенс
      if (map.containsKey(key + 1)) {
        //что будет больше ? текущая длинна или новый сабсиквенс??
        result = Math.max(result, map.get(key + 1) + map.get(key));
      }
    }
    return result;
  }
}
