package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class WordLadderIIFast {

  public static void main(String[] args) {
    WordLadderIIFast ladderII = new WordLadderIIFast();
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

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    List<List<String>> res = new ArrayList<>();
    Set<String> dictionary = new HashSet<>(wordList);

    //нам надо как то еще не закрутится в бес цикле
    //для этого сделаем сет из слов к посещению то есть что бы не возвращаться к уже текущим словам
    //значения этого сета будем удалять из словаря
    Set<String> beginSet = new HashSet<>();
    beginSet.add(beginWord);

    boolean foundFlag = false;

    //будем использовать мапу для того что бы хранить всевозможные пути, чейны
    // которые заканчиваются на это слово
    Map<String, List<List<String>>> map = new HashMap<>();

    //кладем туда начальный элемент - он будет представлять
    //чейн из одного элемента
    List<String> initChain = new ArrayList<>();
    initChain.add(beginWord);
    map.put(beginWord, new ArrayList<>());
    map.get(beginWord).add(initChain);

    //раскручиваем цикл до тех пор пока наш словарь не опустеет либо наш сет не опустеет
    while (!dictionary.isEmpty() && !foundFlag && !beginSet.isEmpty()) {
      // удаляем все текущие слова из нашего словаря
      dictionary.removeAll(beginSet);

      // вот тут мы будем формировать слои для посещения
      //нам нужен такой сет - коллектор из сформированных на текущем шаге новых слов
      //которые есть в словаре - значение этого сета мы будем исп на сл шаге как отправную точку
      Set<String> newBeginSet = new HashSet<>();

      // раскручиваем цикл по все возможным началам нашего сета
      //а все возможные началы - это будут слова которые мы на предыдущем шаге
      //сформировали и добавли в сет visited
      for (String currWord : beginSet) {

        char[] wordCh = currWord.toCharArray();
        List<List<String>> currWordChains = map.get(currWord);

        //пробегаем по каждой букве в слове
        for (int i = 0; i < wordCh.length; i++) {
          // и заменяем каждую букву на остальные 25 возможных из английского алфавита
          //пытаемся найти такое слово, вновьобразованное которое есть в нашем словаре
          for (char ch = 'a'; ch <= 'z'; ch++) {
            if (wordCh[i] == ch) {
              continue;
            }
            //запоминаем стаурю букву, что бы в конце ее вернуть
            char oldLetter = wordCh[i];
            wordCh[i] = ch;

            String newWord = new String(wordCh);
            //если в словаре это слово есть - биго
            //итого найдя какое-то новое слово подбором,
            // мы аппендим это новое слово во все чейны которое наше текущее слово имеет
            if (dictionary.contains(newWord)) {
              newBeginSet.add(newWord);

              for (List<String> chain : currWordChains) {

                List<String> newChain = new ArrayList<>(chain);
                newChain.add(newWord);
                map.putIfAbsent(newWord, new ArrayList<>());
                map.get(newWord).add(newChain);

                if (newWord.equals(endWord)) {
                  foundFlag = true;
                  res.add(newChain);
                }
              }

            }
            //возвращаем замененный символ на место
            wordCh[i] = oldLetter;
          }
        }
        //в конце мы удаляем текущее слово из мапы - и соотв чейны которое оно заканчивает
        //нам больше не интересно текущее слово, нам интересно только нове слова
        //на которые оканчивается наши чейны
        map.remove(currWord);
      }
      // очищаем все предыдушие слова из сета
      beginSet.clear();
      //и добавляем все новые слова
      beginSet.addAll(newBeginSet);

    }

    return res;
  }

}
