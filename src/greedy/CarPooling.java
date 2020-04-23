package greedy;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

  public boolean carPooling(int[][] trips, int capacity) {
    if (trips == null || trips.length == 0) {
      return true;
    }

    // the passenger number delta at each location
    // TreeMap, implements SortedMap, which put the entry in the order by the key automatically
    Map<Integer, Integer> map = new TreeMap<>();

    for (int[] trip : trips) {
      int num = trip[0];
      int start = trip[1];
      int end = trip[2];

      map.put(start, map.getOrDefault(start, 0) + num); // load
      map.put(end, map.getOrDefault(end, 0) - num); // unload
    }

    int total = 0;
    for (int num : map.values()) {
      total += num;
      if (total > capacity) {
        return false;
      }
    }

    return true;
  }
}
