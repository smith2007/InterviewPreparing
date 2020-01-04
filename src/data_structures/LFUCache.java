package data_structures;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
    }
    //три мапы в целом
    //первая мапа - ключ-значение
    private Map<Integer, Integer> keyToVal = new HashMap<>();

    //вторая мапа ключ-каунт
    private Map<Integer, Integer> keyToCount = new HashMap<>();

    //третья мапа каунт на линкед хэш сет из ключей, если минимумов несколько там будет несколько элементов
    private Map<Integer, LinkedHashSet<Integer>> countToSet = new HashMap<>();

    //держим минимумальный каунтер
    //идея в том что бы держать минимум
    //нам по факту не нужна сортировка, нам нужен минимум использований
    private int minCount = 0;

    //и размер
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        // шаг 1 получаем само значение из кэша
        // и кол-во обращений за ним
        // считаем новое обращение
        int val = keyToVal.get(key);
        int oldFreq = keyToCount.get(key);
        int newFreq = oldFreq + 1;

        //2. удаляем старый счетчик из третьей мапы
        LinkedHashSet<Integer> oldSet = countToSet.get(oldFreq);
        oldSet.remove(key);

        //3. апдейтим каунтер минимума если это необходимо
        if (minCount == oldFreq && oldSet.size() == 0) {
            minCount++;
        }

        //4. апдейтим вторую мапу - сетим обновленный каунтер для нее
        keyToCount.put(key, newFreq);

        //апдейтим или вставляем новый элемент в третью мапу -> каунтер-на хэш сет
        countToSet.putIfAbsent(newFreq, new LinkedHashSet<>());
        countToSet.get(newFreq).add(key);

        return val;

    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        //если ключ уже присутсвует
        //положи обновленное значение
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            //элемент уже приствует ничего больше делать не надо - выходим
            return;
        }

        //элемент новый, надо сначала удалить минимум
        //и только затем добавлять новое значение


        //удалить минимум если размер кэша стал превышать capacity
        //просто берем минимум и удаляем элемент по этому ключу
        //из всех мап
        if (keyToVal.size() >= capacity) {
            int keyToRemove = countToSet.get(minCount).iterator().next();
            countToSet.get(minCount).remove(keyToRemove);
            keyToCount.remove(keyToRemove);
            keyToVal.remove(keyToRemove);
        }

        //
        //добавляем ключ во все мапы
        //в мапу с каунтером
        keyToCount.put(key, 1);
        keyToVal.put(key, value);
        countToSet.putIfAbsent(1, new LinkedHashSet<>());
        countToSet.get(1).add(key);
        minCount = 1;
    }
}

