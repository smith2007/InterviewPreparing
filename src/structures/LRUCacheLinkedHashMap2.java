package structures;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap2 {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int capacity = 0;

    public LRUCacheLinkedHashMap2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else if (cache.size() == capacity){
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}
