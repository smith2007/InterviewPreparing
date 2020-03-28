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
    List<int[]> columns = new ArrayList<>();

    //у нас на руках получается трио массив из трех элементов
    // 2 9 10, 2 - левая граница, 9 - правая граница, 10 - верхняя граница
    //мы складываем в двумерный массив
    for (int[] building : buildings) {
      // начальная точка имеет отрицательное значение высоты
      columns.add(new int[]{building[0], -building[2]}); // этот элемент содержит левую границу и верхнюю границу
      // конечная точка имеет нормальное значение высоты
      columns.add(new int[]{building[1], building[2]}); // тут правая граница и верхняя граница
    }

    //сортируем по возрастанию нашей левой границы здания
    //по итогу получим все начала зданий по возрастанию
    Collections.sort(columns, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    //используем тримапу что бы хранить всевозможные высоты,
    //можно и heap использовать, но хип не поддерживает удаление элемента за логарифмическое время
    //а вот три поддерживает remove, add и getMax за lgN время
    //итого
    // ключ: высоты, value: кол-во таких высот
    TreeMap<Integer, Integer> heightToCountMap = new TreeMap<>();
    heightToCountMap.put(0, 1);
    // до старта предыдущая макс высота как бы полагаем что она равна 0
    int prev = 0;



    // посещаем все точки по порядку
    // суть этого цикла в следущем - берем prev и current
    //
    for (int[] column : columns) {
      // стартовая как бы точка - добавляем ВЫСОТЫ каждой колонки


      //далее смотрим каждую высоту в отдельности
      //массив column[0] - точка на оси Х, column[1] - точка на оси Y - она же как бы высота колонки (может быть инвертированной)
      //если она инвертированная
      if (column[1] < 0) {
        //то кладем ее в мапу каунтеров, предварительно
        heightToCountMap.merge(-column[1], 1, Integer::sum);
      } else {  // конечная точка - удаляем высоту
        if (heightToCountMap.get(column[1]) > 1) {
          heightToCountMap.put(column[1], heightToCountMap.get(column[1]) - 1);
        } else {
          heightToCountMap.remove(column[1]);
        }
      }

      //начинаем последней высоты
      int cur = heightToCountMap.lastKey();

      // сравниваем текущую max height с предыдущей max height,
      // обновляем массив res и предыдущий max height если необходимо
      if (cur != prev) {
        List<Integer> point = new ArrayList<>();
        point.add(column[0]);
        point.add(cur);
        res.add(point);
        prev = cur;
      }
    }
    return res;
  }

}
