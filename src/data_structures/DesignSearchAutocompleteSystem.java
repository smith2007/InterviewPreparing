package data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignSearchAutocompleteSystem {

  /**
   * Your AutocompleteSystem object will be instantiated and called as such: AutocompleteSystem obj =
   * new AutocompleteSystem(sentences, times); List<String> param_1 = obj.input(c);
   */
  TrieNode root;
  TrieNode currNode;
  String inputString;

  public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
    this.root = new TrieNode();
    this.inputString = "";
    //набиваем мапу исторических значений - предложений и времени - сколько раз они были введены
    for (int i = 0; i < sentences.length; i++) {
      insert(sentences[i], times[i]);
    }
    this.currNode = root;
  }

  private void insert(String str, int time) {
    TrieNode currNode = root;
    //как набиваем?
    //траверсим символ за символом
    for (int i = 0; i < str.length(); i++) {
      //взяли символ
      char ch = str.charAt(i);
      //берем текущую ноду
      //и кладем в нее пустой пока TrieNode
      //для того что бы в сл итерации положить уже ее ребенка
      //заметь на две строчки ниже мы ведь делаем переприсвоение
      //      currNode = currNode.children.get(ch);
      //вот это. значит на сл шаге мы вернем к только созданной ноде
      currNode.children.putIfAbsent(ch, new TrieNode());
      currNode = currNode.children.get(ch);
      //кладем обновленное слово и кол-во раз сколько оно встречалось
      currNode.countsMap.put(str, currNode.countsMap.getOrDefault(str, 0) + time);
    }
  }

  //ну и наконец метод input
  public List<String> input(char newChar) {
    //сразу формируем массив резов
    List<String> res = new ArrayList<>();

    //смотрим что к нам пришло - если символ завершения предложения - то это повод
    //недавно введенную и зафиксированную строчку скинуть в Trie
    if (newChar == '#') {
      //используем для сброса наш старый добрый метод insert
      insert(inputString, 1);
      //возвращаем наш каррент на начальный рут
      currNode = root;
      //обнуляем строчку
      inputString = "";
    } else {

      //если же пришел символ отличный от # - это повод дальше
      //набивать нашу inputString
      inputString += newChar;
      //тут проверяем что если наша текущая нода пустая или дети не содержат
      //ребенка с новым символом - это значит что чувак набивает какую-то
      //абсалютно новую строку - которую мы до этого не встречали ранее
      if (currNode == null || !currNode.children.containsKey(newChar)) {
        //надо занулить currNode для сл поколений - эта строка новая - она еще не скинута в Trie
        //по этому извините, как только введете # так сразу мы ее зафиксируем
        currNode = null;
        return res;
      } else {

        //а вот если нода есть - значит мы ранее что-то похожее набивали
        //она будет нашей новой головной нодой - мы с нее будем набивать топ3
        currNode = currNode.children.get(newChar);

        //супер - надо инициализировать топ3 для этого используем кучу
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(3, (a, b) -> {
          int first = Integer.compare(b.getValue(), a.getValue());
          if (first != 0) {
            return first;
          }
          return a.getKey().compareTo(b.getKey());
        });

        //для добавления в кучу все те сущности из мапы которые матчатся данному символу
        //то есть даже нырять не надо уже данный символ знает к каким словам и сколько разз введенным он приведет
        pq.addAll(currNode.countsMap.entrySet());

        //ну и все здесь только крутимся 3 раза набиваем массив резов из трех наиболее частых символов
        for (int i = 0; i < 3; i++) {
          if (pq.isEmpty()) {
            return res;
          }
          res.add(pq.poll().getKey());
        }
      }
    }
    return res;
  }


  static class TrieNode {

    public Map<Character, TrieNode> children;
    public Map<String, Integer> countsMap;

    public TrieNode() {
      children = new HashMap<>();
      countsMap = new HashMap<>();
    }
  }


}
