package bfs;

public class BattleshipsInABoardIterative {

  /**
   * решается через простой БФС - причем итеративный, нам надо следить так что бы мы искали как бы
   * хвост этого корабля, ну и голову
   */
  public int countBattleships(char[][] board) {
    int m = board.length;
    if (m == 0) {
      return 0;
    }
    int n = board[0].length;

    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        //если это точка - пропускаем
        if (board[i][j] == '.') {
          continue;
        }
        //если предыдущий горизонтальный символ X - пропускаем
        if (i > 0 && board[i - 1][j] == 'X') {
          continue;
        }
        //если предыдущий вертикальный символ X - пропускаем
        if (j > 0 && board[i][j - 1] == 'X') {
          continue;
        }
        //а вот если мы пришли сюда, значит не точка и предыдущий не Х
        //значит - вот он наш корабль - это его хвост, ну или голова
        count++;
      }
    }

    return count;
  }

}
