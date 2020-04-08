package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }

  /**
   * решается легко достаточно, надо лишь создать вспомогательный коллектор, это может быть стек, я
   * использовал второй эррейлист
   * <p>
   * начинаем с того что сплитаем нашу основную строчку по слешам через path.split("/+")
   * <p>
   * далее крутимся по получившемуся массиву и смотри что за текущий элемент у нас перед нами, если
   * это точка или пустая строка то скипаем нам это не интересно
   * <p>
   * если это две точки то нам необхоидимо из нашего стека попнуть или из нашего массива взять наш
   * элемент последний и удалить а если это слово или имя директории то надо добавить
   */

  static String simplifyPath(String path) {
    if (path == null || path.isEmpty()) {
      return null;
    }

    String[] pathArr = path.split("/+");

    List<String> res = new ArrayList<>();

    for (String curr : pathArr) {
      if (curr.isEmpty() || curr.equals(".")) {
        continue;
      }
      if (curr.equals("..") && res.size() > 0) {
        res.remove(res.size() - 1);
      } else if (!curr.equals("..")) {
        res.add(curr);
      }
    }

    return "/" + String.join("/", res);


  }
}
