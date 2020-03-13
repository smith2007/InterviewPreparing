package string;

import java.util.HashMap;
import java.util.Map;

public class AnagramIndex {

  public static void main(String[] args) {
    System.out.println(find("actkil","kit"));
  }

  static int find(String first, String second) {

    if (first == null || second == null) {
      return -1;
    }

    if (first.length() < second.length()) {
      return -1;
    }

    int i = 0;
    int j = second.length() - 1;
    Map<Character, Integer> map2 = new HashMap<>();

    for (char ch2 : second.toCharArray()) {
      map2.merge(ch2, 1, Integer::sum);
    }

    Map<Character, Integer> map1 = new HashMap<>();
    String substring = first.substring(i, j+1);
    for (char ch1 : substring.toCharArray()) {
      map1.merge(ch1, 1, Integer::sum);
    }

    while (j < first.length() - 1) {
      if (map1.equals(map2)) {
        return i;
      }
      if (j+1<first.length()){
        Integer counti = map1.get(first.charAt(i));
        if (counti - 1 == 0) {
          map1.remove(first.charAt(i));
        } else {
          map1.put(first.charAt(i), counti - 1);
        }
        map1.merge(first.charAt(j+1), 1, Integer::sum);
      }
      i++;
      j++;
    }
    return -1;
  }

}
