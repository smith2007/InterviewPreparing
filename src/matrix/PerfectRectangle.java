package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PerfectRectangle {

  /**
   * БУДЕМ РЕШАТЬ ЭТУ ЗАДАЧА ПУТЕМ НАБИВАНИЯ ПЛОЩАДИ КАЖДОГО МАЛЕНЬКОГО
   * ПРЯМОУГОЛЬНИКА
   *
   * затем найдем две точки - самый самый левый
   *
   * и самый самый правый - перемножим их и сравним эти две площади
   */
  public boolean isRectangleCover(int[][] rectangles) {

    if (rectangles.length == 0 || rectangles[0].length == 0) {
      return false;
    }

    int bigRectBottomLeft = Integer.MAX_VALUE;
    int bigRectBottomRight = Integer.MIN_VALUE;
    int bigRectTopLeft = Integer.MAX_VALUE;
    int bigRectTopRight = Integer.MIN_VALUE;

    HashSet<String> set = new HashSet<>();

    int cumulativeArea = 0;

    for (int[] rectangle : rectangles) {
      //самая левая нижняя точка
      bigRectBottomLeft = Math.min(rectangle[0], bigRectBottomLeft);
      bigRectTopLeft = Math.min(rectangle[1], bigRectTopLeft);

      //самая правая верхняя точка
      bigRectBottomRight = Math.max(rectangle[2], bigRectBottomRight);
      bigRectTopRight = Math.max(rectangle[3], bigRectTopRight);

      cumulativeArea += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);

      //добавлять будем координату
      String bottomLeft = rectangle[0] + " " + rectangle[1];
      String bottomRight = rectangle[0] + " " + rectangle[3];
      String topLeft = rectangle[2] + " " + rectangle[3];
      String topRight = rectangle[2] + " " + rectangle[1];


      //вот тут проверяем оверлап
      //метод add - возвращает true - если сет раньше не содержал этот элемент
      //то есть не было реплейса
      if (!set.add(bottomLeft)) {
        set.remove(bottomLeft); //если содержал - удаляем
      }
      if (!set.add(bottomRight)) {
        set.remove(bottomRight);
      }
      if (!set.add(topLeft)) {
        set.remove(topLeft);
      }
      if (!set.add(topRight)) {
        set.remove(topRight);
      }
    }

    //проверка на оверлап
    if (!set.contains(bigRectBottomLeft + " " + bigRectTopLeft)
        || !set.contains(bigRectBottomLeft + " " + bigRectTopRight)
        || !set.contains(bigRectBottomRight + " " + bigRectTopLeft)
        || !set.contains(bigRectBottomRight + " " + bigRectTopRight)
        || set.size() != 4) {
      return false;
    }

    return cumulativeArea == (bigRectBottomRight - bigRectBottomLeft) * (bigRectTopRight - bigRectTopLeft);
  }
}

