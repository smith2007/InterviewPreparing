package data_structures;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache2 {

    /**
     * ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
     *   [[3],     [2,2],[1,1], [2],  [1],  [2], [3,3],[4,4], [3],  [2],  [1],  [4]]
     */
    public static void main(String[] args) {
        LFUCache2 cache = new LFUCache2(0 /* capacity */);


        cache.put(0, 0);

        cache.get(0);       // returns 1
/*        cache.get(1);       // returns -1 (not found)
        cache.get(2);       // returns 3.
        cache.put(3, 3);
        cache.put(4, 4);    // evicts key 1.
        cache.get(3);       // returns -1 (not found)
        cache.get(2);       // returns 3
        cache.get(1);
        cache.get(4);// returns 4*/
    }

    private int capacity;
    private int min;
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToCount;
    private Map<Integer, LinkedHashSet<Integer>> countToKeys;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToKeys = new HashMap<>();
    }

    public int get(int key) {
        Integer val = keyToVal.get(key);
        if (val == null) {
            return -1;
        }

        int oldCount = keyToCount.get(key);
        int newCount = oldCount + 1;

        if (oldCount == min) {
            if (countToKeys.get(oldCount).size() == 1) {
                min = newCount;
            }
        }
        keyToCount.remove(key);

        countToKeys.get(oldCount).remove(key);

        if (countToKeys.get(oldCount).size() == 0) {
            countToKeys.remove(oldCount);
        }

        keyToCount.put(key, newCount);


        LinkedHashSet<Integer> chain = countToKeys.getOrDefault(newCount, new LinkedHashSet<>());
        chain.add(key);

        countToKeys.put(newCount, chain);

        return val;

    }

    public void put(int key, int value) {

        if (capacity <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }

        if (keyToVal.size() == capacity) {
            int keyToRemove = countToKeys.get(min).iterator().next();
            countToKeys.get(min).remove(keyToRemove);
            if (countToKeys.get(min).size() == 0) {
                countToKeys.remove(min);
            }
            keyToVal.remove(keyToRemove);
            keyToCount.remove(keyToRemove);
        }

        keyToVal.put(key, value);
        keyToCount.put(key, 1);
        min = 1;
        LinkedHashSet<Integer> chain = countToKeys.getOrDefault(min, new LinkedHashSet<>());
        chain.add(key);
        countToKeys.put(min, chain);
    }
}
