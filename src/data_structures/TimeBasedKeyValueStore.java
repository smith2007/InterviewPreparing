package data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

  public static void main(String[] args) {

  }


  private Map<String, TreeMap<Integer, String>> map;

  /**
   * ну по факту надо хранить мапу мап? да мапу тримап - очень простая задача надо всего лишь
   * хранить основные ключи в мапе, а временные ключи в treemap, затем смотреть есть ли наш
   * таймстемп в тримапе, если нет то надо делать бинарный поиск
   * <p>
   * для бинарного поиска в TreeMap есть метод         Integer floor = treeMap.floorKey(timestamp);
   * - он возвращает ближайший ключ к тому что послал на входе, ну либо надо реализовать свой
   * кастомный бинарный поиск
   */
  public TimeBasedKeyValueStore() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new TreeMap<>());
    }
    map.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> treeMap = map.get(key);
    if (treeMap == null) {
      return "";
    }
    Integer floor = treeMap.floorKey(timestamp);
    if (floor == null) {
      return "";
    }
    return treeMap.get(floor);
  }

}
