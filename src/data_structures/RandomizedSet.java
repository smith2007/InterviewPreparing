package data_structures;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {


    public static void main(String[] args) {

        RandomizedSet set = new RandomizedSet();

        set.insert(33);
        set.insert(55);
        set.insert(88);

        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println("-------");

        set.insert(99);

        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println("-------");
        set.remove(33);

        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());


    }
    private Map<Integer, Integer> idToObj = new HashMap<>();
    private Map<Integer, Integer> objToId = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {


    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (objToId.containsKey(val)) {
            return false;
        }

        int newId = objToId.size();
        idToObj.put(newId, val);
        objToId.put(val, newId);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int obj) {
        Integer idForRemove = objToId.get(obj);
        if (idForRemove == null) {
            return false;
        }
        int lastId = idToObj.size() - 1;

        objToId.remove(obj);
        idToObj.remove(idForRemove);

        if (lastId != idForRemove && idToObj.size() != 0) {
            Integer lastObj = idToObj.get(lastId);
            objToId.remove(lastObj);
            idToObj.remove(lastId);

            objToId.put(lastObj, idForRemove);
            idToObj.put(idForRemove, lastObj);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return idToObj.get(ThreadLocalRandom.current().nextInt(0, idToObj.size()));
    }
}
