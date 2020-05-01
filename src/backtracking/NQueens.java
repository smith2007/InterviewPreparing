package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  /**
   * принцип решения такой - ставим первую королеву и от нее пляшем бэктрекингом
   * ставим на i j позицию королеву
   *
   * наша королева может ходить только вверх, вних и по диагонали
   *
   * надо поставить королеву и дальше нырять ставить в другие безопасные места
   * затем по принципу бектрекинга - королеву убрать
   *
   * далее ставим уже сл i j  и так далее
   */
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];

    List<List<String>> res = new ArrayList<>();

    //Intialize the board with '.'
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        //билдим нашу доску  -  по дефолту дли начала заполняем точками
        board[i][j] = '.';
      }
    }
    //далее принцип бектрекинга
    buildBoard(board, 0, n, new ArrayList<>(), res);
    return res;
  }

  public void buildBoard(char[][] board, int row, int n, List<String> temp,
      List<List<String>> res) {

    //как только поняли что достигли нужного размера - это повод добавить в результирующий массив
    if (row == n) {
      temp = new ArrayList<>();//create a new list so it doesn't contain any additional elements
      // from previous recursion calls

      //тут билдим нашу как бы матрицу в строковом виде
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


  //а что такое безопасное место???
  //там где внизу вверху и по диагоналям не смогут атаковать
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
}