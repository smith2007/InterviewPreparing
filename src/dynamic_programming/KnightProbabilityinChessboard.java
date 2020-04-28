package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityinChessboard {

  private static int[][] directions = new int[][]{
      {-2, 1},
      {-1, 2},
      {1, 2},
      {2, 1},
      {2, -1},
      {1, -2},
      {-1, -2},
      {-2, -1}
  };
  private Map<String, Double> cache = new HashMap<>();

  /**
   * тут надо использовать dfs с мемоизацией - разбегаться во всех направлениях и смотреть к чему это приведет
   * Time complexity is O(8^K),
   */
  public double dfs(int N, int K, int r, int c) {

    // Probability that the knight moves to a particular cell is 1/8 = 0.125
    // Probability that the knight is within a board is
    // 0.125(moves to one cell) * (probability to move from first cell till K == 0)
    // + 0.125(moves to second sell) * (probability to move from second cell till K ==0)
    // + ... + 0.125(moves to eight cell) * (probability to move from eighth cell till K ==0)

    //если вышли за пределы массива
    if (r < 0 || r >= N || c < 0 || c >= N) {
      return 0;
    }
    //если достигли K - то все возвращаем 1
    if (K == 0) {
      return 1;
    }
    //ключом мемоизации будет то какой результат мы можем получить с этой позиции с оставшимся кол-вом
    //ходов K
    String key = r + "-" + c + "-" + K;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    double probability = 0;
    for (int i = 0; i < 8; i++) {
      probability =
          probability + 0.125 * dfs(N, K - 1, directions[i][0] + r, directions[i][1] + c);
    }

    cache.put(key, probability);
    return probability;
  }

}
