package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

  public static void main(String[] args) {

  }

  //то есть мы заранее заготавливаем вот такой массив возможных ходов
  //во все направления
  //для того что бы сдедать наш BFS - нам надо класть в очередь новые координаты
  //координаты надо считать от каждой текущей отправной точки
  //а как считать новые координаты??? надо держать в голове возможные ходы
  //что бы потом просто прибавлять к оси абсцисс и оси ординат
  private final int[][] DIRECTIONS = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1},
      {-1, -2}, {1, -2}, {2, -1}};

  public int minKnightMoves(int x, int y) {
    //для того что бы сократить время
    //обязательно надо взять значения координат по модулю
    x = Math.abs(x);
    y = Math.abs(y);

    //координаты будем складывать в очередь
    Queue<int[]> queue = new LinkedList<>();
    int[] initialPoint = {0, 0};
    queue.add(initialPoint);
    // так же нам надо не зациклится - по этому будем делать массив visited
    Set<String> visited = new HashSet<>();
    visited.add("0,0");

    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size != 0) {
        int[] cur = queue.remove();
        int curX = cur[0];
        int curY = cur[1];
        if (curX == x && curY == y) {
          return result;
        }
        for (int[] d : DIRECTIONS) {
          int newX = curX + d[0];
          int newY = curY + d[1];
          int[] newPoint = {newX, newY};

          if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
            queue.add(newPoint);
            visited.add(newX + "," + newY);
          }
        }
        size--;
      }

      result++;
    }
    return -1;
  }

}
