package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

  public static void main(String[] args) {
    PartitionLabels ins = new PartitionLabels();
    List<Integer> res = ins.partitionLabels("ababcbacadefegdehijhklij");
    for (Integer re : res) {
      System.out.println(re);
    }

  }

  /**
   * HashMap + Window: HashMap<char, rightmostIndex> 1. Remember the rightmost index of each
   * character 2. Within the [leftmostIndex, rightmostIndex], if other char's right most exceeds the
   * current, use the larger rightmostIndex
   * <p>
   * <p>
   *
   * достаточно интересная концепция тут - а именно - мапа с rightmostIndex + 2 pointers суть в том
   * что мы набиваем мапу с символами напротив каждого симовла - самый дальний его индекс ну а затем
   * как пляшем двумя указателями рассматривая каждый итый символ в строке и пытаемся понять размеры
   * окна сканируя все символы от начала и до этого самого длинного символа
   * <p>
   * если мы встречаем новый символ который находится дальше чем наш предыдущий самый дальний -
   * обновляем его
   */
  public List<Integer> partitionLabels(String str) {

    List<Integer> res = new ArrayList<>();
    //будем запоминать самый правый индекс для каждого символа
    HashMap<Character, Integer> map = new HashMap<>();
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], i);
    }

    //теперь работаем двумя указателями
    int left = 0;
    int right = 0;

    while (right < chars.length) {
      //мы как бы ищем окно, и проверяем что все символы внутри этого окна
      //они находятся внутри его
      //это делается путем        right = Math.max(right, rightMostIndexOfCurrentChar);
      for (int i = left; i <= right; i++) {
        //берем нащ самый правый индекс
        char currChar = chars[i];
        int rightMostIndexOfCurrentChar = map.get(currChar);
        //если мы встречаем новый символ который находится дальше чем наш предыдущий самый дальний -
        // обновляем его - ТО ЕСТЬ РАСШИРЯЕМ ОКНО
        right = Math.max(right, rightMostIndexOfCurrentChar);
      }
      //left добежит и перебежит right
      //вот тут на выходе мы имеем размер этого самого окна
      //а теперь добавляем подстроку
      res.add(right - left + 1);
      left = right + 1;
      right = left;
    }
    return res;
  }

}
