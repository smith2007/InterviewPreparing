package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

  /**
   * 221.LongestSubstringwithAtMostKDistinctCharacters
   * <p>
   * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
   * <p>
   * дана строка и число k - выведи длинну такой подстроки котора будет содержать меньше или равно k
   * уникальных символов
   * <p>
   * <p>
   * Input: s = "eceba", k = 2 Output: 3 T is "ece" which its length is 3.
   * <p>
   * задача решается довольно просто через два указателя мапу и максимум крутимся в цикле двумя
   * указателями i j жытый бежит вперед и мержит мапу каунтеров каждый раз как размер мапы <= k
   * сразу пытаемся обновить максимум текущим размером : max = Math.max(j - i + 1, max); но как
   * только размер мапы привысит k сразу подключаем итый символ который побежит вперед и будет
   * удалять все символы который под ним модифицируя мапу до тех пор пока опять не достигнем мапы
   * размером k
   */
  public static void main(String[] args) {

    System.out.println(lengthOfLongestSubstringKDistinct("bacc", 2));

  }

  static int lengthOfLongestSubstringKDistinct(String s, int k) {

    if (s == null || k == 0) {
      return 0;
    }
    //эта задача решается просто через два указателя и мапу
    //а именно j будет бежать вперед и набивать мержить мапу каунтеров
    int i = 0;
    int j = 0;

    Map<Character, Integer> map = new HashMap<>();

    char[] chars = s.toCharArray();
    int max = 0;
    while (j < chars.length) {

      char jch = chars[j];
      map.merge(jch, 1, Integer::sum);

      //каждый раз когда размер мапы меньше или равен
      //тому что мы ищем - сразу пытаемся обновить максимум
      if (map.size() <= k) {
        max = Math.max(j - i + 1, max);
      } else {

        //но как только мы достигли того что мапа разрослась
        while (map.size() > k) {
          //сразу подключается итый указатель
          //который бежит вперед и удаляем все символы которые под ним
          //до тех пор пока не получим мапу нужного нам размера
          char ich = chars[i];
          Integer counti = map.get(ich);
          if (counti - 1 == 0) {
            map.remove(ich);
          } else {
            map.put(ich, counti - 1);
          }
          i++;
        }
      }

      j++;
    }

    return max;
  }
}
