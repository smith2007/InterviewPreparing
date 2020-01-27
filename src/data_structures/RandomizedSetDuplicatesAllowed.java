package data_structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSetDuplicatesAllowed {

    Map<Integer, Node> idToObj = new HashMap<>();
    Map<Node, Integer> objToId = new HashMap<>();
    Map<Integer, LinkedList<Node>> valToLinkedList = new HashMap<>();


    public static void main(String[] args) {

        RandomizedSetDuplicatesAllowed set = new RandomizedSetDuplicatesAllowed();

        System.out.println(set.insert(33));
        System.out.println(set.insert(33));
        System.out.println(set.insert(88));
/*
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
        System.out.println(set.getRandom());*/


    }

    /**
     * Initialize your data structure here.
     */
    public RandomizedSetDuplicatesAllowed() {



    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        int newId = idToObj.size();
        boolean result = valToLinkedList.containsKey(val);

        Node newNode = new Node(val);

        LinkedList<Node> linkedList = valToLinkedList.getOrDefault(val, new LinkedList<>());
        linkedList.add(newNode);
        valToLinkedList.put(val, linkedList);

        idToObj.put(newId, newNode);
        objToId.put(newNode, newId);
        return !result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        LinkedList<Node> linkedList = valToLinkedList.get(val);
        if (linkedList == null) {
            return false;
        }

        Node nodeForRemove = linkedList.removeLast();
        if (valToLinkedList.get(val).isEmpty()) {
            valToLinkedList.remove(val);
        }
        Integer idForRemove = objToId.get(nodeForRemove);

        int lastId = idToObj.size() - 1;
        Node lastNode = idToObj.get(lastId);

        objToId.remove(nodeForRemove);
        idToObj.remove(idForRemove);

        if (lastId != idForRemove) {
            objToId.remove(lastNode);
            idToObj.remove(lastId);

            objToId.put(lastNode, idForRemove);
            idToObj.put(idForRemove, lastNode);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return idToObj.get(ThreadLocalRandom.current().nextInt(0, idToObj.size())).val;
    }

    static class Node {
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
