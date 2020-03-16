package array;

public class PrisonCellsAfterNDaysSmart {

  /**
   * 229.PrisonCellsAfterNDays
   * <p>
   * https://leetcode.com/problems/prison-cells-after-n-days/
   * <p>
   * перед нами тюрьма с 8 камерами в ряд так же каждая камера может быть либо свободна либо занята
   * каждый день не зависимо от того занята камера или свободна - ее состояние меняется
   * <p>
   * -  Если у ячейки есть два соседних соседа, которые оба заняты или оба свободны, то ячейка
   * становится занятой. - в противном случае ячейка становится свободной
   * <p>
   * надо держать в уме что так как камеры расположены в ряд то первая и последняя ячейки не могут
   * иметь сразу два соседних элемента соотв на входе у нас массив с нулями и единицами дано
   * начальное состояние тюрьмы - верни состояние через N дней
   * <p>
   * Input: cells = [0,1,0,1,1,0,0,1], N = 7 Output: [0,0,1,1,0,0,0,0] Explanation: The following
   * table summarizes the state of the prison on each day: Day 0: [0, 1, 0, 1, 1, 0, 0, 1] Day 1:
   * [0, 1, 1, 0, 0, 0, 0, 0] Day 2: [0, 0, 0, 0, 1, 1, 1, 0] Day 3: [0, 1, 1, 0, 0, 1, 0, 0] Day 4:
   * [0, 0, 0, 0, 0, 1, 0, 0] Day 5: [0, 1, 1, 1, 0, 1, 0, 0] Day 6: [0, 0, 1, 0, 1, 1, 0, 0] Day 7:
   * [0, 0, 1, 1, 0, 0, 0, 0]
   * <p>
   * окей так как камер 8 то логично что здесь 255 различных коомбинаций, соотв для больших чисел
   * будет цикл
   * <p>
   * нам неоходимо найти как то паттерн повторения - зацикливание получается 14 - через каждые 14
   * дней наш паттерн повторяется
   * <p>
   * <p>
   * соотв нам надо взять наш N на входе и разделить его по модулю на 14 и затем посчитать для
   * нового, обновленного N
   */
  public static void main(String[] args) {

    int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
    prisonAfterNDays(arr, 7);
  }


  static int[] prisonAfterNDays(int[] cells, int N) {
    N = N % 14;
    if (N == 0) {
      N = 14;
    }
    int[] res = new int[cells.length];
    for (int i = 0; i < N; i++) {
      res = convert(cells);
      cells = res;
    }
    return res;
  }

  static int[] convert(int[] cells) {
    int[] res = new int[cells.length];
    for (int i = 1; i < cells.length - 1; i++) {
      if (cells[i - 1] == cells[i + 1]) {
        res[i] = 1;
      } else {
        res[i] = 0;
      }
    }
    return res;
  }


}
