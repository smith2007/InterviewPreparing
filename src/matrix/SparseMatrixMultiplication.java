package matrix;

public class SparseMatrixMultiplication {

  public static void main(String[] args) {

    int[][] matrixA = {{1, 0, 0},
        {-1, 0, 3}};

    int[][] matrixB = {{7, 0, 0},
        {0, 0, 0},
        {0, 0, 1}};

    System.out.println(multiply(matrixA, matrixB));
  }

  static int[][] multiply(int[][] a, int[][] b) {
    //результирующая матрица С
    //помни матчасть - размер матрицы будет длинна - по а а ширина по b
    //матрица интов - по дефолту заполнена нулями
    int[][] c = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        //если a[i][j] == 0 то умножать смысла нет
        if (a[i][j] != 0) {
          //если не ноль то пробегаем по столбцам матрицы b
          //и формируем c[i][k] элемент матрицы путем накладывания в нее сумм произведений
          for (int k = 0; k < b[0].length; k++) {
            if (b[j][k] != 0) {
              c[i][k] = c[i][k] + a[i][j] * b[j][k];
            }
          }
        }
      }
    }
    return c;
  }

}
