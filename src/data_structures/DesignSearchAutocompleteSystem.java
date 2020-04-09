package data_structures;

import java.util.*;

public class DesignSearchAutocompleteSystem {

  /**
   * Your AutocompleteSystem object will be instantiated and called as such: AutocompleteSystem obj =
   * new AutocompleteSystem(sentences, times); List<String> param_1 = obj.input(c);
   *
   *
   *
   *
   * 262.DesignSearchAutocompleteSystem
   *
   * https://leetcode.com/problems/design-search-autocomplete-system/
   *
   * задизайни систему автокомплита при поиске - простыми словами фулл текст серч. Пользователи могут вводить предложение (хотя бы одно слово и заканчиваться специальным символом «#»).
   * Для каждого символа, который они вводят, кроме «#», тебе нужно вернуть 3 самых популярных исторических предложения, которые имеют префикс, совпадающий с уже введенной частью предложения. По определенным правилам:
   *
   * 1 - Горячесть для предложения определяется как количество раз, когда пользователь вводил одно и то же предложение ранее.
   *
   * 2 - Возвращенные топ-3 горячих предложения должны быть отсортированы по этой как бы горячей степени (первая - самая горячая). Если несколько предложений имеют одинаковую степень нагрева, вам нужно использовать порядок ASCII-кода (сначала появится меньшее).
   *
   * 3 - если менее чем 3 предложения было введено - верни столько сколько есть
   *
   * 4 - Когда на входе у нас специальный символ, это означает, что предложение заканчивается, и в этом случае вам необходимо вернуть пустой список.
   *
   * наша задача имплементировать вот такой вот метод
   *
   * конструктор:   AutocompleteSystem(String[] sentences, int[] times)
   *
   * на вхоже у нас как бы исторические данные, та информация которую раньше вводили и сколько раз вводили - нам надо где-то прикопать данную информацию
   * теперь пользователь хочет ввести новое предложение , вот этот метод должен принимать символ за символом новое предложение
   * пока на входе не будет # - List<String> input(char c)
   * c - это введенный пользователем символ. символ будет только в нижнем регистре и буквы от a до z, пробелы или #
   * так же предыдущее предложение должно быть где-то сохранено в системе
   *
   * на выходе надо получить топ 3 исторических предложения котороые имеют преффикс такой же как и уже введенное предложение
   *  
   * Example: Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) Система уже выследила следующие предложения и их соответствующиее кол-во раз сколько они были вызваны: "i love you" : 5 times "island" : 3 times "ironman" : 2 times "i love leetcode" : 2 times
   *  теперь юзер вводит новое предложение   Operation: input('i') Output: ["i love you", "island","i love leetcode"] Explanation: There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.  Operation: input(' ') Output: ["i love you","i love leetcode"] Explanation: There are only two sentences that have prefix "i ".  Operation: input('a') Output: [] Explanation: There are no sentences that have prefix "i a".  Operation: input('#') Output: [] Explanation: The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
   *  
   *
   * крутая задача, в принципе схожая со всеми Trie но все же, основная идея что нам надо набивать Динамически наше Trie, символ за символом и хранить каунт и конечное слово - то есть идея вот в чем каждая наша нода - тобишь каждый наш символ знает к какому слову он приведет и сколько раз он встретися - это нам очень поможет что бы DFS-ом каждый раз не нырять и не набивать то что нужно вернуть для автокомплита - офигенно
   *
   * соотв наша нода выглядит так
   *
   * static class TrieNode {
   *   public Map<Character, TrieNode> children;
   *   public Map<String, Integer> countsMap;
   * }
   *
   * сам наш основной класс содержит вот такой набор полей
   *   TrieNode root; // ссылка на рутовую - пустую ноду
   *   TrieNode currNode; // всегда держим текущую ноду с которой происходит текущее набитие строки
   *   String inputString; // ну и сама набиваемая строка
   *
   * она ждет когда мы пришлем символ # и тогда мы сможем ее вмержить в Trie
   *
   * очень очень внимательно надо делать
   *
   * в классе будет 2 метода
   *
   *   private void insert(String str, int time) // изначально в конструкторе набиваем массив слов - исторический
   * public List<String> input(char newChar) // тот самый публичный метод - ждет символа # что бы смыть строку в Trie
   *
   * а как смыть строку?? ну конечно же вызвать первый метод insert
   * ну а если это новый символ надо добавить его в текущую ноду currNode (в мапу ее детей) и обновить currNode что бы от нее уже плясать
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
      //тут то вся и фишка что каждая наша нода - тобишь каждый наш символ знает к какому слову он приведет
      //и сколько раз он встретися
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
