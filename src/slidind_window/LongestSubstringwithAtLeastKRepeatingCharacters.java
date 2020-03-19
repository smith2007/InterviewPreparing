package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(longestSubstring("ccabababnn", 3));
  }


  static int longestSubstring(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();

    // мержим мапу каунтеров
    for (int i = 0; i < s.length(); i += 1) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }

    //сразу делаем проверку а может быть все символы там встречаются меньше чем к раз??
    boolean flag = true;
    for (int count : map.values()) {
      if (count < k) {
        flag = false;
        break;
      }
    }
    // возвращаем длинн строки если действительно все символы встречаются ровно столько раз сколько надо
    if (flag) {
      return s.length();
    }

    //далее если гипотеза не подтвердилась, будем раскручивать цикл двумя указателями
    //фиксируя максимум
    int max = 0;
    int i = 0;
    int j = 0;

    //причем раскручиваем очень хитро - ПРИНЦИП - УБЕРИ СИМВОЛ ОБУЗУ и посчитай на подстроке
    //как только мы встетили символ который дает нам кол-во встречаний меньше чем надо
    //мы запускаем рекурсивно ту же функцию на еще раз но на под строку которая не включает этот символ
    //и всю подстроку впередистоящую перед ним, как бы мы понимаем что этот символ обуза,
    //он не дает того что нам надо и строчку его содержащую надо исключить
    while (j < s.length()) {
      if (map.get(s.charAt(j)) < k) {
        max = Math.max(max, longestSubstring(s.substring(i, j), k));
        i = j + 1;//итый символ встает на сл жытый как бы
      }
      j++;
    }
    //как только мы дошли до конца, то есть житый указатель уперся в конец, то давай
    //еще проверим подстрочку строчку начиная от житого символа
    return Math.max(max, longestSubstring(s.substring(i), k));

  }


}
