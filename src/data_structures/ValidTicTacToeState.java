package data_structures;

public class ValidTicTacToeState {

  public boolean validTicTacToe(String[] board) {
    int xCount = 0, oCount = 0;
    for (String row: board)
      for (char cell: row.toCharArray()) {
        if (cell == 'X') xCount++;
        if (cell == 'O') oCount++;
      }

    if (oCount != xCount && oCount != xCount - 1) return false;
    if (win(board, 'X') && oCount != xCount - 1) return false;
    if (win(board, 'O') && oCount != xCount) return false;
    return true;
  }

  public boolean win(String[] board, char player) {
    // B: board, P: player
    for (int i = 0; i < 3; ++i) {
      if (player == board[0].charAt(i) && player == board[1].charAt(i) && player == board[2].charAt(i))
        return true;
      if (player == board[i].charAt(0) && player == board[i].charAt(1) && player == board[i].charAt(2))
        return true;
    }
    if (player == board[0].charAt(0) && player == board[1].charAt(1) && player == board[2].charAt(2))
      return true;
    if (player == board[0].charAt(2) && player == board[1].charAt(1) && player == board[2].charAt(0))
      return true;
    return false;
  }
}
