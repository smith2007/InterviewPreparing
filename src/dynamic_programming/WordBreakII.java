package dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

  public static void main(String[] args) {
    WordBreakII wordBreakII = new WordBreakII();
    Set<String> set = new HashSet<>();
    set.add("cat");
    set.add("cats");
    set.add("and");
    set.add("sand");
    set.add("dog");
    List<String> list = wordBreakII.wordBreak("catsanddog", set);

    for (String s : list) {
      System.out.println(s);
    }

  }

  /**
   * ну простое решение брут форс это идти и как бы dfs бектрекингом ставя пробел идя по каждой
   * букве ставим пробел между ними как только нашли слово - зашибись - это наш вариант - запускаем
   * как бы альтернативную ветку рекурсии предпологая что наше первое слово это оно и продолжая
   * дальше идти по символам и проверяя что символ есть там
   * <p>
   * <p>
   * более умное решение скорее всего сводится как то к динамическому программированию через мапу с
   * мемоизацией
   * <p>
   * идея вся та же что и в брут форсе, но теперь мы вводим мапу которая в качестве ключа содержит
   * индекс - с какой строки какие варианты у нас есть!
   * <p>
   * Map<Integer, List<String>> map - то есть ныряя мы же будем сканировать эту строку правильно??
   * соотв вернувшись мы уже будем знать какие варианты у нас на руках есть что с 5 индекса такие то
   * слова будут с 10 индекса такие то слова и так далее
   * <p>
   * пользуемся этим когда дальше траверсим нашу строку в основном цикле - сводим задачу к O(n^3)
   * <p>
   * круто и намного намного проще и понятно чем с этим массивом dp
   */
  public List<String> wordBreak(String str, Set<String> wordDict) {
    return dfs(str, wordDict, 0);
  }

  HashMap<Integer, List<String>> map = new HashMap<>();

  public List<String> dfs(String str, Set<String> dictionary, int start) {
    if (map.containsKey(start)) {
      return map.get(start);
    }

    LinkedList<String> res = new LinkedList<>();
    if (start == str.length()) {
      res.add("");
    }

    for (int i = start + 1; i <= str.length(); i++) {

      String word = str.substring(start, i);

      if (dictionary.contains(word)) {
        //ныряем и запускаем наш метод на подстроке
        //передаем ему индекс i - с какого начинать рассматривать
        List<String> resultWhenWeDivedFromCurrWordList = dfs(str, dictionary, i);
        //получили результат ныряния
        //что будет если мы будем взяли и рассматриваем текущее слово как начало чейна
        for (String nextWord : resultWhenWeDivedFromCurrWordList) {
          nextWord = (nextWord.isEmpty() ? nextWord : " ") + nextWord;
          //ну все добавляем
          res.add(word + nextWord);
        }
        //и погнали дальше крутится в цикле for (int i = start + 1; i <= str.length(); i++)
        //вот в этом, но фишка то в том что ныряя в dfs на этом текущем шаге
        //мы уже просканировали пространство впереди
        //и набили мапу она то нам и поможет в дальнейшем вот в этом цикле
      }
    }

    map.put(start, res);
    return res;
  }

}
