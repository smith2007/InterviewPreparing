package matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidSudoku {

  public static void main(String[] args) {

  }

  /**
   * эта задача решается через 3 мапы каунтеров, 1 мапа мапа значений которые проставлены
   * в клетках по вертикали
   * 2 мапа значений по горизонтале и третяя мапа это значения в каждом блоке 3x3
   *
   * принцип такой - мы идем по нашей матрице и сканируем символ за символом наши числа
   * - и если такое число уже ранее было встречено - значит судоку не валидна - что логично
   * по вертикали горизонтале и коробе должны быть только уникальные числа
   *
   * самое интересно как посчитать индекс короба - вот формула
   */
  public boolean isValidSudoku(char[][] board) {
    // init data
    List<HashMap<Integer, Integer>> rows = new ArrayList<>();
    List<HashMap<Integer, Integer>> columns = new ArrayList<>();
    List<HashMap<Integer, Integer>> boxes = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      rows.add(new HashMap<>());
      columns.add(new HashMap<>());
      boxes.add(new HashMap<>());
    }

    // крутимся в двойном цикле по нашей доске
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        //берем каждый итый житый символ
        char num = board[i][j];
        if (num != '.') {
          int n = num;

          // keep the current cell value
          rows.get(i).merge(n, 1, Integer::sum);
          columns.get(j).merge(n, 1, Integer::sum);

          //так расчитывается индекс нашего квадрата
          int boxIndex = (i / 3) * 3 + j / 3;

          boxes.get(boxIndex).merge(n, 1, Integer::sum);

          // проверям что такой элемент был встречен ранее - значит судоку НЕ валидна
          if (rows.get(i).get(n) > 1 || columns.get(j).get(n) > 1
              || boxes.get(boxIndex).get(n) > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
