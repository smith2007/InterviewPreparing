package string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EncodeandDecodeStrings {

  /**
   * тут основная проблема в том что использовтаь в качестве делиметера
   * ведь наша строка может содердать все 256 ацких символов
   *
   * вариант использовать не ацкий символ
   *
   * есть другие варианты, например
   * конкретно в этом решении мы записываем то кол-во сиволов вместе с делиметором и вычитываем потом
   * его
   */
  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length()).append('/').append(s);//кладем длинну и слеш как разделитель
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int slash = s.indexOf('/', i);//вычитыввем слеш
      int size = Integer.parseInt(s.substring(i, slash));
      i = slash + size + 1;
      res.add(s.substring(slash + 1, i));//и берем сабстринг
    }
    return res;
  }

}
