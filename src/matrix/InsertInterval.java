package matrix;

import java.util.LinkedList;

public class InsertInterval {


  public static void main(String[] args) {

  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    // сразу обозначим две переменные для простоты
    int newStart = newInterval[0];
    int newEnd = newInterval[1];

    int i = 0;
    int n = intervals.length;

    //результат будем накладывать в линкед лист так как из него легко удалять если что
    LinkedList<int[]> output = new LinkedList<>();

    //добавляем все интервалы которые начинаются ДО нашего нового интервала
    while (i < n && newStart > intervals[i][0]) {
      output.add(intervals[i]);
      i++;
    }

    // создаем новый интервал
    int[] newMergedInterval = new int[2];

    // если нет никаких пересечений - просто добавь новый интевал
    if (output.isEmpty() || output.getLast()[1] < newStart) {
      output.add(newInterval);
    } else {
      // если есть пересечения - надо смержить с последним интервалом
      //надо удалить из листа последний
      newMergedInterval = output.removeLast();
      //взять макс конец
      newMergedInterval[1] = Math.max(newMergedInterval[1], newEnd);
      //и снова добавить
      output.add(newMergedInterval);
    }

    //добавляем следующие интервалы и мерджим с новым интервалом, если необходимо
    while (i < n) {
      newMergedInterval = intervals[i];
      int start = newMergedInterval[0];
      int end = newMergedInterval[1];
      // если нет пересечений - просто добавляем
      //то есть начало сканируемого строго меньше чем начало нашего нового
      if (output.getLast()[1] < start) {
        output.add(newMergedInterval);
      } else {
        // если пересечения есть - надо мержить
        newMergedInterval = output.removeLast();
        newMergedInterval[1] = Math.max(newMergedInterval[1], end);
        output.add(newMergedInterval);
      }
      i++;
    }
    return output.toArray(new int[output.size()][2]);
  }


}
