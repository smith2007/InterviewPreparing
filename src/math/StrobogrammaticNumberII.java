package math;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

  /**
   *
   *
   * на входе число n
   *
   * найди все субраматик числа которые будут длинной n
   * составь все пермутации таких коомбинаций
   *
   *
   * complexity
   * <p>
   * Upper limit is Math.pow(5, n) because each position has at most 5 options 0, 1, 8, 6, 9 and we
   * have n/2 positions to fill. Like a 5-ary tree.
   */
  List<String> res = new ArrayList<>();

  public List<String> findStrobogrammatic(int n) {
    //если n четное
    if (n % 2 == 0) {
      getRes(n, "");
    } else {
      //если не четное - значит по середине что-то долно быть
      getRes(n - 1, "1");
      getRes(n - 1, "0");
      getRes(n - 1, "8");
    }
    return res;
  }

  public void getRes(int n, String collector) {
    //мы постепенно будем уменьшать n
    //набивая строку как только дошли до 0
    //значит строку набили
    if (n == 0) {
      res.add(collector);
      return;
    }
    //нули слева не могут быть тогда получится 010 что не валидно
    if (n != 2) {
      getRes(n - 2, "0" + collector + "0");
    }
    //добавляем вокруг числа
    //обрамляем как бы слева и справа всевозможными коомбинациями
    getRes(n - 2, "6" + collector + "9");
    getRes(n - 2, "9" + collector + "6");
    getRes(n - 2, "1" + collector + "1");
    getRes(n - 2, "8" + collector + "8");
  }
}