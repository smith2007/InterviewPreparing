package slidind_window;

public class MaximalSquareSlidingWindow {

  public static void main(String[] args) {

  }

  /**
   * идея очень простая - представь квадрат который сканирует как бы матрицу и растет каждый раз
   * когда он содержит только единицы

   * метод isSquare получает координаты с левого верхнего угла квадрата и размер площади
   * и он проверяет что в указаном секторе только единицы, если это так то все это повод расширить границы и попробовать еще раз
   *
   */
  public int maximalSquare(char[][] matrix) {
    int size = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        //обходим каждый элемент и рассматриваем его как
        //потенциальный край нашего квадрата
        while (isSquare(matrix, i, j, size)) {
          //если это квадрат - то это повод увеличить размеры - может быть там лежит что то большее
          //именно по этому цикл вайл
          size++;
        }
      }
    }
    return size * size;
  }

  private boolean isSquare(char[][] matrix, int startI, int startJ, int size) {
    //тут мы определяем размеры нашего окна
    //начинаем с startI startJ
    //плюс сдвиг по size
    int endI = startI + size;
    int endJ = startJ + size;
    //если размеры окна выпадают за размер массива - все - все сорян
    //уже не валидно
    if (endI > matrix.length - 1 || endJ > matrix[0].length - 1) {
      return false;
    }
    //ну и проверям что в указанном квадрате есть только единицы
    for (int i = startI; i <= endI; i++) {
      for (int j = startJ; j <= endJ; j++) {
        if (matrix[i][j] != '1') {
          return false;
        }
      }
    }
    return true;
  }
}
