package divide_and_conquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {

  public static void main(String[] args) {

    TheSkylineProblem problem = new TheSkylineProblem();

    int[][] matr = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    problem.getSkyline(matr);
  }

  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> res = new ArrayList<>();
    List<int[]> heights = new ArrayList<>();

    for (int[] building : buildings) {
      // начальная точка имеет отрицательное значение высоты
      heights.add(new int[]{building[0], -building[2]});
      // конечная точка имеет нормальное значение высоты
      heights.add(new int[]{building[1], building[2]});
    }

    //сортируем по убыванию наши высоты
    Collections.sort(heights, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    //используем тримапу что бы хранить всевозможные высоты,
    //можно и хим использовать, но хип не поддерживает удаление элемента за логарифмическое время
    //а вот три поддерживает remove, add и getMax за lgN время
    //итого
    // ключ: высоты, value: кол-во таких высот
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    treeMap.put(0, 1);
    // до старта предыдущая макс высота как бы полагаем что она равна 0
    int prev = 0;
    // посещаем все точки по порядку
    for (int[] height : heights) {
      // стартовая как бы точка - добавляем высоту
      if (height[1] < 0) {
        treeMap.merge(-height[1], 1, Integer::sum);
      } else {  // конечная точка - удаляем высоту
        if (treeMap.get(height[1]) > 1) {
          treeMap.put(height[1], treeMap.get(height[1]) - 1);
        } else {
          treeMap.remove(height[1]);
        }
      }

      int cur = treeMap.lastKey();

      // сравниваем текущую max height с предыдущей max height,
      // обновляем массив res и предыдущий max height если необходимо
      if (cur != prev) {
        List<Integer> point = new ArrayList<>();
        point.add(height[0]);
        point.add(cur);
        res.add(point);
        prev = cur;
      }
    }
    return res;
  }

}
