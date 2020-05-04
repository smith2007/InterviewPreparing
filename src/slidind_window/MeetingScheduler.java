package slidind_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {

  /**
   * по началу надо отсортировать оба по времени начала - ну а затем тут два указателя
   * - смотрим что больше что меньше и ищем подходящий слот
   */
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    if (slots1 == null || slots1.length == 0 || slots2 == null || slots2.length == 0 || duration < 0){
      return Collections.emptyList();
    }

    Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

    int len1 = slots1.length;
    int len2 = slots2.length;

    int i = 0, j = 0;
    while (i < len1 && j < len2) {
      int[] s1 = slots1[i];
      int[] s2 = slots2[j];

      // Find intersection of their availability slots

      int earliestStart = Math.max(s1[0], s2[0]);
      int earliestEnd = Math.min(s1[1], s2[1]);

      if (earliestStart + duration <= earliestEnd)
        return new ArrayList<>(Arrays.asList(earliestStart, earliestStart + duration));

      else {
        if (s1[1] <= s2[1]) i++;
        else
          j++;
      }
    }
    return Collections.emptyList();
  }

}
