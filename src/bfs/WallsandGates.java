package bfs;

public class WallsandGates {

  public static void main(String[] args) {

  }

  /**
   * решаем через dfs - ищем нули - пляшем от нулей дфс-ом с каунтером путей - dist
   * во все направления если вышли за пределы массива, наткнулись на -1
   * либо в rooms[i][j] уже ранее стоял какое-то число
   * то тогда просто скип
   *
   * а вот если там ничего не стоит тогда заполняем нашим каунтером
   */
  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0){
          dfs(rooms, i, j, 0);
        }
      }
    }
  }

  private void dfs(int[][] rooms, int i, int j, int dist) {
    if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < dist){
      return;
    }
    rooms[i][j] = dist;
    dfs(rooms, i - 1, j, dist + 1);
    dfs(rooms, i + 1, j, dist + 1);
    dfs(rooms, i, j - 1, dist + 1);
    dfs(rooms, i, j + 1, dist + 1);
  }
}
