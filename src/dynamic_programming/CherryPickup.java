package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CherryPickup {

  /**
  When user goes forward, collects maximum cherries, there is a possibility that the return path may not cover a total of maximum cherries. We may hve to find a way to optimize the COMBINED paths of forward and backward.

  This can be done by moving forward together as 2 users from beginning to end.
  Since the users travel together, they will technically reach the end point together.

  Caveat : return 1 user's exit and not both's ( thats not even possible )
  > When they are in the same point, cover just 1 cherry, meaning the other won't get it.


   дана матрица размера n x n - которая представляет собой поля с вишнями - каждая ячейка
   - представляет собой одно из трех возможных значений

   * 0 означает, что клетка пуста, так что вы можете пройти;
   * 1 означает, что клетка содержит вишню, которую вы можете взять и пройти;
   * -1 означает, что клетка содержит шип, который блокирует ваш путь.
    
   наша задача - собрать максимальное число вишен возможных согласно следующим правилам:



   задача напоминает робота, решаем через динамическое программирование,
   но тут нам надо РАЗДЕЛЯЕМСЯ НА ДВА ПОТОКА  с мемоизацией пути

   смотрим что будет - рассматриваем разные коомбинации первый пошел вниз второй вправа
   первый пошел вправо второй вниз и так далее

  */

  //сюда будем мемоизировать
  Map<String, Integer> map;

  public int cherryPickup(int[][] grid) {
    map = new HashMap<>();
    return Math.max(0, travelForward(0, 0, 0, 0, grid));
  }

  /**
   The person travels as 2 people forward.
   There are 4 combinations for this :
   i + 1, j, i1 + 1, j1 -> both go down
   i + 1, j, i1, j1 + 1 -> first goes down, second goes to the right
   i, j + 1, i1 + 1, j1 -> first goes to the right, second goes down
   i, j + 1, i1, j1 + 1 -> first goes to the right, second goes to the right

   We have to obtain the max of this
   */
  private int travelForward(int i, int j, int i1, int j1, int[][] grid) {

    //если вышли за пределы массива - возвращаем минимальное значение
    //или же где-то встретился -1 -то есть препятсвие
    if (i > grid.length - 1 || j > grid[0].length - 1 || i1 > grid.length - 1
        || j1 > grid[0].length - 1 || grid[i][j] == -1 || grid[i1][j1] == -1) {
      return Integer.MIN_VALUE;
    }

    //мемоизируем наш путь с помощью ключа коомбинированого
    String key = i + "-" + j + "-" + i1 + "-" + j1;
    if (map.containsKey(key)) {
      return map.get(key);
    }

    //если кто-то из них дошел до конца - возвращаем значение из грида
    //потом будем суммировать
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }
    if (i1 == grid.length - 1 && j1 == grid[0].length - 1) {
      return grid[i1][j1];
    }

    int res; // вот тут получаем результат это либо просто
    //grid[i][j]; либо grid[i][j] + grid[i1][j1];
    if (i == i1 && j == j1) { //если 1ый и 2ой чуваки на одинаковом месте стоят
      //то просто возвращаем итый жытый из грида
      res = grid[i][j];
    } else {
      //если же не на одинаковом месте - то суммируем
      res = grid[i][j] + grid[i1][j1];
    }

    int max1 = Math.max(travelForward(i + 1, j, i1 + 1, j1, grid),
        travelForward(i + 1, j, i1, j1 + 1, grid));
    int max2 = Math.max(travelForward(i, j + 1, i1 + 1, j1, grid),
        travelForward(i, j + 1, i1, j1 + 1, grid));

    res += Math.max(max1, max2);
    //мемоизируем наш результат
    map.put(key, res);
    return res;
  }


}
