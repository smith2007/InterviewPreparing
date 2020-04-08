package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public List<List<String>> solveNQueens(int n) {
    char board[][] = new char[n][n];

    List<List<String>> res = new ArrayList<>();

    //Intialize the board with '.'
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }

    buildBoard(board, 0, n, new ArrayList<>(), res);
    return res;
  }


  public boolean isSafePlace(char[][] board, int row, int col, int n) {

    for (int i = row - 1; i >= 0; i--) {//up
      if (board[i][col] == 'Q') {
        return false;
      }
    }
    for (int i = row + 1; i < n; i++) {//down
      if (board[i][col] == 'Q') {
        return false;
      }
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {//left uppder diagonal
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {//right bottom diagonal
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {//right upper diagonal
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {//left bottom diagonal
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }




  public void buildBoard(char[][] board, int row, int n, List<String> temp,
      List<List<String>> res) {

    //как только поняли что достигли нужного размера - это повод добавить в результирующий массив
    if (row == n) {
      temp = new ArrayList<>();//create a new list so it doesn't contain any additional elements
      // from previous recursion calls

      for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          sb.append(board[i][j]);
        }
        temp.add(sb.toString()); //add every column to the list
      }

      res.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (isSafePlace(board, row, i, n)) {//before placing a queen call this function to check if it is safe
        board[row][i] = 'Q';
        buildBoard(board, row + 1, n, temp, res);
        board[row][i] = '.';
      }
    }
  }
}