package backtracking;

public class NQueensII {

  /**
   * This is a classic backtracking problem.
   *
   * Start row by row, and loop through columns.
   * At each decision point, skip unsafe positions by using three boolean arrays.
   *
   * Start going back when we reach row n.
   */
  int count = 0;

  public int totalNQueens(int n) {

    boolean[] cols = new boolean[n];     // columns   |
    boolean[] d1 = new boolean[2 * n];   // diagonals \
    boolean[] d2 = new boolean[2 * n];   // diagonals /
    backtracking(0, cols, d1, d2, n);
    return count;
  }

  public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
    //как только достигли нужного числа королев - апдейтим глобальный каунтер
    if (row == n) {
      count++;
    }

    for (int col = 0; col < n; col++) {

      int diag1Index = col - row + n;
      int diag2Index = col + row;

      //проверяем что в этой колонке ничего не стоит
      //и в диагоналях ничего не стоти
      if (cols[col] || d1[diag1Index] || d2[diag2Index]) {
        continue;
      }

      cols[col] = true;
      d1[diag1Index] = true;
      d2[diag2Index] = true;

      backtracking(row + 1, cols, d1, d2, n);

      cols[col] = false;
      d1[diag1Index] = false;
      d2[diag2Index] = false;
    }
  }
}
