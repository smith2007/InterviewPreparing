package dynamic_programming;

public class AndroidUnlockPatterns {

  /**
   * ну тут на ум приходит сразу бектрекинг с массивом визититетов типа нырять от каждого элемента матрицы
   *
   * более умная идея - рассматривать все возможные коомбинации - исключая не валидные
   */
  private static int[][] dirs1 = new int[][]{
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},
      {1, 1}, {-1, -1}, {1, -1}, {-1, 1},
      {2, 1}, {2, -1}, {-2, -1}, {-2, 1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2},
  };
  private static int[][] dirs2 = new int[][]{
      {2, 0}, {0, 2}, {-2, 0}, {0, -2},// need check middle visited[i+dir[0]/2][j+dir[1]/2]
  };
  private static int[][] dirs3 = new int[][]{
      {2, 2}, {-2, -2}, {2, -2}, {-2, 2}// need check visited[1,1]
  };

  private int count = 0;

  public int numberOfPatterns(int m, int n) {
    boolean[][] visited = new boolean[3][3];
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        visited[i][j] = true;
        dfs(m, n, 1, visited, i, j);
        visited[i][j] = false;
      }
    }
    return count;
  }

  private void dfs(int m, int n, int chainCount, boolean[][] visited, int i, int j) {

    if (chainCount >= m && chainCount <= n) {
      count++;
      if (chainCount >= n) {
        return;
      }
    }
    //рассматриваем первый массив направлений
    for (int[] dir : dirs1) {
      int newI = i + dir[0];
      int newJ = j + dir[1];

      //тут делаем бэектрекинг
      if (newI >= 0 && newI < 3 && newJ >= 0 && newJ < 3 && !visited[newI][newJ]) {
        visited[newI][newJ] = true;
        dfs(m, n, chainCount + 1, visited, newI, newJ);
        visited[newI][newJ] = false;
      }
    }

    //второй массив направлений
    for (int[] dir : dirs2) {
      int newI = i + dir[0];
      int newJ = j + dir[1];
      if (newI >= 0 && newI < 3 && newJ >= 0 && newJ < 3 && !visited[newI][newJ] && visited[i + dir[0] / 2][j
          + dir[1] / 2]) {
        visited[newI][newJ] = true;
        dfs(m, n, chainCount + 1, visited, newI, newJ);
        visited[newI][newJ] = false;
      }
    }

    //и третий массив направлений
    for (int[] dir : dirs3) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && x < 3 && y >= 0 && y < 3 && !visited[x][y] && visited[1][1]) {
        visited[x][y] = true;
        dfs(m, n, chainCount + 1, visited, x, y);
        visited[x][y] = false;
      }
    }
  }
}
