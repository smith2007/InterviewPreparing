package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {

  public static void main(String[] args) {
    LongestArithmeticSequence ins = new LongestArithmeticSequence();
    int[] arr = {9, 4, 7, 2, 10};
    int i = ins.longestArithSeqLength(arr);
    System.out.println(i);
  }

  /**
   * The main idea is to maintain a 2-D array that store diffs that are seen before. The trick
   * without using a HashMap is from the note: 0 <= a[i] <= 10000. So we can initiate
   * dp[a.length][diff] where 0 <= diff <= 20001 because Java array doesn't support negative index.
   * <p>
   * <p>
   *
   *   тут два указателя j i - жытый бежит вперед и а итый его догоняет
   *   и смотрит разницу - дельту межу arr[i] и arr[j]
   *
   *   ну и сохраняет ее в массив мап dp
   *
   * тут главная идея состоит в том что мы таскаем с собой массив мап из дельт как бы
   * которые мы видели до этого
   * <p>
   * то есть для каждого элемента массива - мы набиваем мапу из дифов
   * <p>
   * для этого мы двумя указателями итым и жытым
   */
  public int longestArithSeqLength(int[] arr) {
    int maxLength = 2;
    HashMap<Integer, Integer>[] dp = new HashMap[arr.length];
    //жытый бежит вперед, итый его догоняет
    for (int j = 0; j < arr.length; j++) {
      //каждый жытый элемент будет содержать дельту
      //между этим текущим жытым и его сзадистоящими элементами
      dp[j] = new HashMap<>();
      for (int i = 0; i < j; i++) {
        int delta = arr[j] - arr[i];
        //дельта - это ключ
        //если такая дельта уже ранее содержалась - то это хорошо, надо ее проапдейтить
        Integer alreadyMetThisDeltaTimes = dp[i].getOrDefault(delta, 1);
        dp[j].put(delta, alreadyMetThisDeltaTimes + 1);
        //ну и наша задача - нати такую вот
        maxLength = Math.max(maxLength, alreadyMetThisDeltaTimes + 1);
      }
    }

    return maxLength;
  }
}
