package union_find;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {

    LongestConsecutiveSequence ins = new LongestConsecutiveSequence();

    int[] arr = {100, 4, 200, 1, 3, 2};
    System.out.println(ins.longestConsecutive(arr));

  }

  /**
   * решать будем через сета это задача из разряда - гениальное просто
   * <p>
   * нам надо всего лишь положить все наши элементы в сет а затем траверсить нам массив - брать
   * отправную точку как бы и разбегаться в разные стороны с шагом 1 накручивая каунтер УДАЛЯЯЯ
   * элементы из сета все, и обновлять максимум
   */
  public int longestConsecutive(int[] nums) {
    int maxSeqLength = 0;

    Set<Integer> set = new HashSet<>();
    //накладываем элементы в сет
    for (int value : nums) {
      set.add(value);
    }

    // пробегаем по каждому
    for (int elm : nums) {
      int currSeqLength = 1;

      // смотрим влево и вправо - разбегаемся влево и вправо с шагом 1
      // и удаляем все элементы которые нам встретились
      //цикл что бы удалить все элементы которые меньше нашего текущего
      for (int i = elm - 1; set.contains(i); i--) {
        currSeqLength++;
        set.remove(i);
      }

      // разбегаемся вправо
      //одновременно с этим подсчитываем длинну
      for (int i = elm + 1; set.contains(i); i++) {
        currSeqLength++;
        set.remove(i);
      }

      maxSeqLength = Math.max(maxSeqLength, currSeqLength);
    }

    return maxSeqLength;
  }
}
