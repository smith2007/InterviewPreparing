package union_find;

public class SurroundedRegions {

  /**
   * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
   * <p>
   * A region is captured by flipping all 'O's into 'X's in that surrounded region.
   * <p>
   * Example:
   * <p>
   * X X X X X O O X X X O X X O X X After running your function, the board should be:
   * <p>
   * X X X X X X X X X X X X X O X X Explanation:
   * <p>
   * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
   * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an
   * 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
   * connected horizontally or vertically.
   */


  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }
    if (board.length < 2 || board[0].length < 2) {
      return;
    }
    int m = board.length, n = board[0].length;
    //Any 'O' connected to a boundary can't be turned to 'X', so ...
    //Start from first and last column, turn 'O' to '*'.
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        boundaryDFS(board, i, 0);
      }
      if (board[i][n - 1] == 'O') {
        boundaryDFS(board, i, n - 1);
      }
    }
    //Start from first and last row, turn '0' to '*'
    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O') {
        boundaryDFS(board, 0, j);
      }
      if (board[m - 1][j] == 'O') {
        boundaryDFS(board, m - 1, j);
      }
    }
    //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == '*') {
          board[i][j] = 'O';
        }
      }
    }
  }

  //Use DFS algo to turn internal however boundary-connected 'O' to '*';
  private void boundaryDFS(char[][] board, int i, int j) {
    if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
      return;
    }
    if (board[i][j] == 'O') {
      board[i][j] = '*';
    }
    if (i > 1 && board[i - 1][j] == 'O') {
      boundaryDFS(board, i - 1, j);
    }
    if (i < board.length - 2 && board[i + 1][j] == 'O') {
      boundaryDFS(board, i + 1, j);
    }
    if (j > 1 && board[i][j - 1] == 'O') {
      boundaryDFS(board, i, j - 1);
    }
    if (j < board[i].length - 2 && board[i][j + 1] == 'O') {
      boundaryDFS(board, i, j + 1);
    }
  }
}
