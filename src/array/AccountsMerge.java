package array;

import java.util.*;

public class AccountsMerge {

  public static void main(String[] args) {
    List<List<String>> input = new ArrayList<>();

    input.add(List.of("John", "johnsmith@mail.com", "john00@mail.com"));
    input.add(List.of("John", "johnnybravo@mail.com"));
    input.add(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    input.add(List.of("Mary", "mary@mail.com"));

    for (List<String> strings : accountsMerge(input)) {
      for (String string : strings) {
        System.out.print(string + " ");
      }

      System.out.println();
    }

  }

  /**
   * input [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"], ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
   * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"], ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
   * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
   * <p>
   * <p>
   * my [["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"], ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
   * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"], ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
   * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"], ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
   * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"], ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
   * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"], ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
   * ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"]]
   * <p>
   * <p>
   * needed
   * <p>
   * [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"], ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
   * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"], ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
   * ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
   */
  /**
   * задачу решаем через дфс обход графа
   */
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    //строим две вот такие мапы
    Map<String, Set<String>> graphMap = new HashMap<>();  //<email node, neighbor nodes>
    Map<String, String> nameMap = new HashMap<>();        //<email, username>
    // Build the graph;
    for (List<String> account : accounts) {
      String userName = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        if (!graphMap.containsKey(account.get(i))) {
          graphMap.put(account.get(i), new HashSet<>());
        }
        nameMap.put(account.get(i), userName);

        if (i == 1) {
          continue;
        }
        //добавляем соседей
        graphMap.get(account.get(i)).add(account.get(i - 1));
        graphMap.get(account.get(i - 1)).add(account.get(i));
      }
    }

    //а потом по простому дфс с массивом visited мы будем
    //обходить наш граф
    Set<String> visited = new HashSet<>();
    List<List<String>> res = new LinkedList<>();
    // DFS search the graph;
    for (String email : nameMap.keySet()) {
      List<String> list = new LinkedList<>();
      if (visited.add(email)) {
        dfs(graphMap, email, visited, list);
        Collections.sort(list);
        list.add(0, nameMap.get(email));
        res.add(list);
      }
    }

    return res;
  }

  static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited,
      List<String> list) {
    list.add(email);
    for (String next : graph.get(email)) {
      if (visited.add(next)) {
        dfs(graph, next, visited, list);
      }
    }
  }
}
