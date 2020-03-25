package data_structures;

public class DesignHashMapSmart {


  public static void main(String[] args) {
    DesignHashMapSmart designHashMap = new DesignHashMapSmart();
    designHashMap.put(1, 1);
  }


  private static final double LOAD_FACTOR = 0.75;
  private LinkedListNode[] linkedListNodes;
  private int size; // number of keys

  /**
   * Initialize your data structure here.
   */
  public DesignHashMapSmart() {
    linkedListNodes = new LinkedListNode[5];
    size = 0;
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    int idx = hash(key);
    for (LinkedListNode x = linkedListNodes[idx]; x != null; x = x.next) {
      if (x.key == key) {
        x.value = value;
        return;
      }
    }
    linkedListNodes[idx] = new LinkedListNode(key, value, linkedListNodes[idx]);
    size++;

    double loadFactor = (double) size / linkedListNodes.length;
    if (loadFactor > LOAD_FACTOR) {
      rehash();
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int idx = hash(key);
    for (LinkedListNode x = linkedListNodes[idx]; x != null; x = x.next) {
      if (x.key == key) {
        return x.value;
      }
    }
    return -1;
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    int idx = hash(key);
    LinkedListNode pre = new LinkedListNode(-1, -1, linkedListNodes[idx]); // sentinal node before list head
    for (LinkedListNode prev = pre; prev.next != null; prev = prev.next) {
      if (prev.next.key == key) {
        prev.next = prev.next.next;
        break;
      }
    }
    linkedListNodes[idx] = pre.next;
    size--;
  }

  private int hash(int key) {
    return key % linkedListNodes.length;
  }

  private void rehash() {
    LinkedListNode[] tmp = linkedListNodes;
    linkedListNodes = new LinkedListNode[tmp.length * 2];
    size = 0;
    for (LinkedListNode head : tmp) {
      for (LinkedListNode x = head; x != null; x = x.next) {
        put(x.key, x.value);
      }
    }
  }

  static class LinkedListNode {

    int key;
    int value;
    LinkedListNode next;

    public LinkedListNode(int key, int value, LinkedListNode next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
}
