package backtracking;

public class TheMaze {

  public static void main(String[] args) {

  }

  int destI;
  int destJ;
  int[][] maze;

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || start == null || destination == null) {
      return false;
    }

    this.maze = maze;
    destI = destination[0];
    destJ = destination[1];
    return dfs(start[0], start[1]);
  }

  private boolean dfs(int i, int j) {

    if (maze[i][j] == -1) {
      return false;
    }

    if (i == destI && j == destJ) {
      return true;
    }
    //красим путь
    maze[i][j] = -1; //to denote that we have already started from this node

    //катимся до конца влево
    //try left
    int index = j;
    while (index >= 0 && maze[i][index] != 1) {
      index--;
    }
    //проверяем результат того что мы докатились
    boolean left = dfs(i, index + 1);
    if (left) {
      return true;
    }

    //try right
    index = j;
    while (index < maze[0].length && maze[i][index] != 1) {
      index++;
    }
    boolean right = dfs(i, index - 1);
    if (right) {
      return true;
    }

    //try up
    index = i;
    while (index >= 0 && maze[index][j] != 1) {
      index--;
    }
    boolean up = dfs(index + 1, j);
    if (up) {
      return true;
    }

    //try down
    index = i;
    while (index < maze.length && maze[index][j] != 1) {
      index++;
    }
    boolean down = dfs(index - 1, j);
    if (down) {
      return true;
    }
    return false;
  }

}
