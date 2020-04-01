package matrix;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {

  public static void main(String[] args) {

  }

  /**
   * в общем да, такой мутный алгоритм - завуалированный алгоритм дейкстры - суть
   * в том что рещать будем через bfs
   * но bfs хитрый - не через обычную очередь а через максимальный хип, накладывать
   * в хип мы будем триплет из значния, координаты и и координаты жы
   *
   * далее крутимся в цикле полим хип берем элемент - обновляем минимальное значение
   * если надо и накладываем соседей в восех четырех направлениях
   */

  public int maximumMinimumPath(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //в приорити кю будем складывать триплет - массив из трех элементов
    // значение ячейки и ее координаты
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max heap

    pq.add(new int[]{matrix[0][0], 0, 0});

    int minValue = matrix[0][0];

    //так же будем помечать путь
    matrix[0][0] = -1; // visited

    while (!pq.isEmpty()) {
      //вытаскиваем триплет
      int[] triplet = pq.poll();
      //берем его координаты
      int i = triplet[1];
      int j = triplet[2];

      //обновляем минимум если надо
      minValue = Math.min(minValue, triplet[0]);

      if (i == n - 1 && j == m - 1) {
        return minValue;
      }

      for (int[] dir : dirs) {
        int newI = i + dir[0];
        int newJ = j + dir[1];
        if (newI < 0 || newI >= n || newJ < 0 || newJ >= m) {
          continue;
        }
        //так как это хип из максимувов мы будет каждый раз накладывая сюда
        //новое направление - брать отсюда макимальный элемент
        pq.add(new int[]{matrix[newI][newJ], newI, newJ});
        matrix[newI][newJ] = -1;
      }
    }
    return -1;
  }

}
