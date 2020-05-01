package matrix;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfDistinctIslands {

  public static void main(String[] args) {
    int[][] matrix = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}};

    System.out.println(numDistinctIslands(matrix));
  }


  /**
   * кароч, задача в принципе не сложная, опять же если включить голову и понять что от нас хотят,
	 * а
   * хотят группировки островов по их форме на клечатой доске, и самое сложное тут это понять как
   * определить что острова имеют одинаковую форму после долгих раздумий пришла идея фиксировать
   * координаты, будто бы каждый остров начинается около точки (0,0) а затем каждая единица (суша
   * как бы) мы фиксируем ее координаты - через строку 0-2 например, ну все наш условный shape это
   * сет из этих координат а наш коллектор это сет таких сетов
   *
   * Set<Set<String>> set
   */
  static int numDistinctIslands(int[][] grid) {

    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    // будем фиксировать координаты тут
    Set<Set<String>> set = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {

        if (grid[i][j] == 1) {
          Set<String> hash = new HashSet<>();
          dive(grid, i, j, hash, 0, 0);
          set.add(hash);
        }
      }
    }

    return set.size();
  }

  static void dive(int[][] grid, int i, int j, Set<String> hash, int coordinateI, int coordinateJ) {

    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {

      grid[i][j] = 0;

      hash.add(coordinateI + "-" + coordinateJ);

      dive(grid, i + 1, j, hash, coordinateI + 1, coordinateJ);
      dive(grid, i, j + 1, hash, coordinateI, coordinateJ + 1);
      dive(grid, i - 1, j, hash, coordinateI - 1, coordinateJ);
      dive(grid, i, j - 1, hash, coordinateI, coordinateJ - 1);
    }
  }
}
