package structures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
     * [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1); // 1
        lruCache.put(2, 2); // 2 1
        lruCache.put(3, 3); // 3 2 1

        lruCache.put(4, 4); // 4 3 2

        System.out.println(lruCache.get(4)); // 4 - 4 3 2
        System.out.println(lruCache.get(3)); // 3 - 3 4 2
        System.out.println(lruCache.get(2)); // 2 - 2 3 4
        System.out.println(lruCache.get(1)); // -1 - 2 3 4

        lruCache.put(5, 5); // 5 2 3

        System.out.println(lruCache.get(1)); // -1 = 5 2 3
        System.out.println(lruCache.get(2)); // 2 = 2 5 3
        System.out.println(lruCache.get(3)); // 3 = 3 2 5
        System.out.println(lruCache.get(4)); // -1 = 3 2 5
        System.out.println(lruCache.get(5)); // 5 = 5 3 2

    }

    static class Node {

        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    Node head;
    Node tail;
    int capacity;

    Map<Integer, Node> map = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node existingNodeByKey = map.get(key);
        if (existingNodeByKey != null) {
            map.remove(key);
            Node preExisting = existingNodeByKey.prev;
            Node nextExisting = existingNodeByKey.next;

            if (preExisting != null) {
                preExisting.next = nextExisting;
            }
            if (nextExisting != null) {
                nextExisting.prev = preExisting;
            }

            if (tail.key == existingNodeByKey.key) {
                tail = tail.prev;
            }

            if (head.key == existingNodeByKey.key) {
                head = head.next;
            }
        }


        Node newNode = new Node(key, value);
        map.put(key, newNode);

        if (head != null && tail != null) {
            Node oldHead = head;
            head = newNode;
            head.next = oldHead;
            oldHead.prev = head;
        } else {
            head = newNode;
            tail = newNode;
        }

        boolean isOverLimit = map.size() > capacity;

        if (isOverLimit) {
            Node removedElm = map.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
            removedElm.next = null;
            removedElm.prev = null;
        }

    }

    public int get(int key) {
        Node elm = map.get(key);

        if (elm == null) {
            return -1;
        }

        if (elm.equals(head)) { // и так стоим на первом месте
            return elm.value;
        }

        Node leftElm = elm.prev;
        Node rightElm = elm.next;

        if (leftElm != null) {
            leftElm.next = rightElm;
        }
        if (rightElm != null) {
            rightElm.prev = leftElm;
        }


        if (elm.equals(tail)){
            tail = tail.prev;
        }

        Node oldHead = head;
        head = elm;
        head.next = oldHead;
        oldHead.prev = head;
        head.prev = null;
        return elm.value;
    }


}
