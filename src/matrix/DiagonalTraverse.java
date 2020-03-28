package matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiagonalTraverse {

  public static void main(String[] args) {

 /*   int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };*/
    int[][] matrix = {
        {2,5,8},{4,0,-1},
    };

    DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
    for (int i : diagonalTraverse.findDiagonalOrder(matrix)) {
      System.out.println(i);
    }


  }

  public int[] findDiagonalOrder(int[][] matrix) {

    if (matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    if (matrix.length == 1 && matrix[0].length>1){
      return matrix[0];
    }

    List<Integer> res = new ArrayList<>();
    boolean up = true;

    //короче я делал в тупую, а именно брал пластами и обходил, смотри картинку сначала обход по столбцам
    //затем обход по строкам
    for (int j = 0; j < matrix[0].length; j++) {

      int col = j;
      int row = 0;
      List<Integer> level = new ArrayList<>();
      while (row != matrix.length && col != -1) {
        level.add(matrix[row][col]);
        row++;
        col--;
      }
      if (up) {
        for (int i = level.size() - 1; i >= 0; i--) {
          res.add(level.get(i));
        }
      } else {
        res.addAll(level);
      }
      up = !up;
    }

    for (int i = 1; i < matrix.length; i++) {
      int col = matrix[0].length - 1;
      int row = i;
      List<Integer> level = new ArrayList<>();

      while (row != matrix.length && col != -1) {
        level.add(matrix[row][col]);
        row++;
        col--;
      }

      if (up) {
        for (int k = level.size() - 1; k >= 0; k--) {
          res.add(level.get(k));
        }
      } else {
        res.addAll(level);
      }
      up = !up;
    }

    int[] arr = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      arr[i] = res.get(i);
    }
    return arr;
  }

}
