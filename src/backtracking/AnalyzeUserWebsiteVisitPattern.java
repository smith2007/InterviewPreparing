package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsiteVisitPattern {

  public static void main(String[] args) {
    AnalyzeUserWebsiteVisitPattern ins = new AnalyzeUserWebsiteVisitPattern();


    String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary",
        "mary"};
    int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about",
        "career"};

    List<String> res = ins.mostVisitedPattern(username, timestamp, website);

    for (String re : res) {
      System.out.println(re);
    }

  }

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, List<Integer>> nameToIndexes = new HashMap<>();
    int n = username.length;

    //1.build Map<name,websiteindex list>
    for (int i = 0; i < n; i++) {
      String name = username[i];
      nameToIndexes.computeIfAbsent(name, val -> new ArrayList<>()).add(i);
    }

    //2.visit every website list
    int maxCount = -1;
    String resultStr = "";
    //сюда будем складировать наши как бы чейны из посещенных сайтов - напротив их частоты
    Map<String, Integer> chainToLengthOfIt = new HashMap<>();
    for (List<Integer> userIndexes : nameToIndexes.values()) {

      //2.1.according to timestamp sorted in ascending order
      //
      Collections.sort(userIndexes, (a, b) -> {
        int ta = timestamp[a];
        int tb = timestamp[b];
        return ta - tb;
      });

      //2.2.get all 3-sequences for each user
      //если чувак менее трех сайтов посетил - тогда уходим с ним ловить нечего
      if (userIndexes.size() < 3) {
        continue;
      }

      Set<String> chainSet = new HashSet<>();//
      backtrack(chainSet, userIndexes, "", 0, 0, website);

      //2.3.update largest number and its user
      for (String str : chainSet) {
        int count = chainToLengthOfIt.getOrDefault(str, 0);

        if (count > maxCount || (count == maxCount && resultStr.compareTo(str) > 0)) {
          resultStr = str;
          maxCount = count;
        }

        chainToLengthOfIt.put(str, count + 1);
      }
    }

    //3.convert answer from string to list
    List<String> result = new ArrayList<>();
    String[] resWebsites = resultStr.split("_");
    for (String site : resWebsites) {
      if (site.equals("")) {
        continue;
      }
      result.add(site);
    }

    return result;
  }


  public void backtrack(Set<String> chainSet, List<Integer> indexesList, String key, int currIndex,
      int count, String[] websites) {
    //как только набили 3 элемента в наш ключ - сразу сбрасываем массив резов и идем дальше
    if (count == 3) {
      //скидываем эту строку в сет резов
      chainSet.add(key);
      return;
    }

    if (currIndex >= indexesList.size()) {
      return;
    }

    for (int i = currIndex; i < indexesList.size(); i++) {
      backtrack(chainSet, indexesList, key + "_" + websites[indexesList.get(i)],
          i + 1, count + 1, websites);
    }
  }

}
