package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {

  public static void main(String[] args) {
    ConcatenatedWords concatenatedWords = new ConcatenatedWords();

    String[] str = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
        "ratcatdogcat"};

    /*String[] str = {"a", "b", "ab", "abc"};*/
    for (String s : concatenatedWords.findAllConcatenatedWordsInADict(str)) {
      System.out.println(s);
    }

  }

  /**
   * ну можно набить перфиксное дерево из всех слов, и каждый символ конечный символ который
   * образует слово - будет содержать это конечное слово
   * <p>
   * после построения нашего дерева такого - мы будем брать каждое слово из массива, которое не
   * равно по длинне минимальному слову, и пытаться расчленить его - то есть свести к пустой строке
   * <p>
   * например построили префиксное дерево, теперь перед нами слово catsdogcats, фигак - ныряем во
   * внутрь пытаемся найти какое то слово которое отсечет первую часть от catsdogcats - нашли cat -
   * отсекаем остается sdogcats - запускаем рекурсивно метод dive
   * <p>
   * кстати этот рекурсивный метод dive будет возращать нам true / false - удалось ли свести наше
   * слово к пустой строке да еще и что бы мы встретили как минимум два раза наши два любых слова из
   * словаря
   */

  TrieNode root;
  int shortest;

  public List<String> findAllConcatenatedWordsInADict(String[] words) {

    this.root = new TrieNode();
    //набиваем мапу исторических значений - предложений и времени - сколько раз они были введены
    for (String word : words) {
      insert(word);
    }

    List<String> res = new ArrayList<>();
    for (String word : words) {
      if (word.length() != shortest && dive(word, 0)) {
        res.add(word);
      }
    }
    return res;
  }

  boolean dive(String word, int metWords) {
    if (word.isEmpty()) {
      return metWords > 1;
    }
    TrieNode curr = root;

    for (int i = 0; i < word.length(); i++) {
      char wordCh = word.charAt(i);

      curr = curr.children.get(wordCh);
      if (curr == null) {
        return false;
      } else if (curr.word != null) {
        if (dive(word.substring(i + 1), metWords + 1)) {
          return true;
        }
      }
    }
    return false;
  }

  private void insert(String str) {
    TrieNode currNode = root;
    shortest = Math.min(shortest, str.length());
    //как набиваем?
    //траверсим символ за символом
    for (int i = 0; i < str.length(); i++) {
      //взяли символ
      char ch = str.charAt(i);
      //берем текущую ноду
      //и кладем в нее пустой пока TrieNode
      //для того что бы в сл итерации положить уже ее ребенка
      //заметь на две строчки ниже мы ведь делаем переприсвоение
      //currNode = currNode.children.get(ch);
      //вот это. значит на сл шаге мы вернем к только созданной ноде
      currNode.children.putIfAbsent(ch, new TrieNode());
      currNode = currNode.children.get(ch);
      //кладем обновленное слово
    }
    currNode.word = str;
  }


  static class TrieNode {

    public Map<Character, TrieNode> children;
    public String word;

    public TrieNode() {
      children = new HashMap<>();
    }
  }


}
