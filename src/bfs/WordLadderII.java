package bfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class WordLadderII {

  public static void main(String[] args) {
    WordLadderII ladderII = new WordLadderII();
    ArrayList<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");
    List<List<String>> ladders = ladderII.findLadders("hit", "cog", wordList);
    for (List<String> ladder : ladders) {
      for (String s : ladder) {
        System.out.print(s + " ");
      }
      System.out.println();
    }

  }

  TreeMap<Integer, List<List<String>>> res = new TreeMap<>(Comparator.naturalOrder());

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    if (wordList.isEmpty()) {
      return new ArrayList<>();
    }

    HashSet<String> dictionary = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    dfs(dictionary, new ArrayList<>(), visited, beginWord, endWord);
    if (res.isEmpty()){
      return new ArrayList<>();
    }
    return res.firstEntry().getValue();
  }

  void dfs(HashSet<String> dictionary, List<String> currChain, Set<String> visited,
      String currWord, String endWord) {

    currChain.add(currWord);

    if (currWord.equals(endWord)) {
      res.putIfAbsent(currChain.size(), new ArrayList<>());
      res.get(currChain.size()).add(currChain);
      return;
    }

    //берем слово - пытаемся подбором понять какие варианты замены у нас есть

    char[] wordCh = currWord.toCharArray();

    for (int i = 0; i < wordCh.length; i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        char old = wordCh[i];
        wordCh[i] = c;
        String newWord = new String(wordCh);

        if (dictionary.contains(newWord) && !visited.contains(newWord)) {
          visited.add(newWord);

          dfs(dictionary, new ArrayList<>(currChain), new HashSet<>(visited), new String(wordCh),
              endWord);
        }
        visited.add(newWord);
        wordCh[i] = old;
      }
    }
  }

}
