package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesandLadders {

  /**
   * решаем через бфс
   */
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    // convert 2D array to 1D to make processing more easier
    //конвертим из матрицы в массив
    int[] flatten = convert2DTo1D(board);

    int targetIdx = n * n - 1; // target index to try to reach
    Queue<Integer> queue = new ArrayDeque<>();  // queue for BFS
    boolean[] visited = new boolean[n * n]; // keep track of which node has been visited
    int steps = 0; // keep track of number of steps (levels) we have gone in BFS
    // add starting node (number 1, index 0) to the queue and start BFS

    int start = flatten[0] == -1 ? 0 : flatten[0] - 1;
    queue.offer(start);
    visited[start] = true;
    // BFS:
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int currIdx = queue.poll();
        // in case the current index is the index we are looking for
        // return the number of moves used to get there
        if (currIdx == targetIdx) {
          return steps;
        }
        // consider all numbers from +1 to +6, note that don't go out of bound
        int upper = Math.min(targetIdx, currIdx + 6);
        for (int nextIdx = currIdx + 1; nextIdx <= upper; nextIdx++) {
          // check if the nextIdx is a snake/ladder
          int dest = flatten[nextIdx] == -1 ? nextIdx : flatten[nextIdx] - 1;

          // in case the next index is already explored, skip it
          if (visited[dest]) {
            continue;
          }
          // add next index into the queue and mark it as visited
          queue.offer(dest);
          visited[dest] = true;
        }
      }
      steps++;
    }
    return -1;
  }

  private int[] convert2DTo1D(int[][] board) {
    int n = board.length;
    // 1D array whose size is n^2
    int[] rst = new int[n * n];
    boolean leftToRight = true; // order to traverse columns in each row
    int idx = 0;

    // start from the bottom row of 2D array, initially going from left to right
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        // if we need to read columns from left to right
        if (leftToRight) {
          rst[idx++] = board[i][j];
        } else {
          // if we need to read columns from right to left
          rst[idx++] = board[i][n - 1 - j];
        }
      }
      // after processing each row, switch the order
      leftToRight = !leftToRight;
    }
    return rst;
  }

}
