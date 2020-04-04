package backtracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII {

  public static void main(String[] args) {

  }

  public int shortestDistance(int[][] maze, int[] start, int[] dest) {
    //делаем технический массив дистанций
    //заполненый макс элементами
    int[][] distance = new int[maze.length][maze[0].length];
    for (int[] row : distance) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    distance[start[0]][start[1]] = 0;
    dijkstra(maze, start, distance);
    return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
  }

  public void dijkstra(int[][] maze, int[] start, int[][] distance) {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    //в очередь будем класть наши координаты по i j а так же наш ПУТЬ
    queue.add(new int[]{start[0], start[1], 0});

    while (!queue.isEmpty()) {
      int[] currPoint = queue.poll();
      int currPointI = currPoint[0];
      int currPointJ = currPoint[1];

      int currPath = currPoint[2];

      if (distance[currPointI][currPointJ] < currPath) {
        continue;
      }
      for (int[] dir : dirs) {
        int newI = currPointI + dir[0];
        int newJ = currPointJ + dir[1];
        int count = 0;

        while (newI >= 0 && newJ >= 0 && newI < maze.length && newJ < maze[0].length
            && maze[newI][newJ] == 0) {
          newI += dir[0];
          newJ += dir[1];
          count++;
        }
        //если текущая величина МЕНЬШЕ чем наша новая - то ее стоит рассмотреть
        //и тогда кладем ее в очередь
        if (distance[currPointI][currPointJ] + count < distance[newI - dir[0]][newJ - dir[1]]) {
          distance[newI - dir[0]][newJ - dir[1]] = distance[currPointI][currPointJ] + count;
          queue.add(
              new int[]{newI - dir[0], newJ - dir[1], distance[newI - dir[0]][newJ - dir[1]]});
        }
      }
    }
  }

}
