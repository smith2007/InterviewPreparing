package data_structures;

public class DesignHashMapPrimitive {


  public static void main(String[] args) {
    DesignHashMapPrimitive designHashMap = new DesignHashMapPrimitive();
    designHashMap.put(1, 1);
  }


  /**
   * Initialize your data structure here.
   */
  public DesignHashMapPrimitive() {

  }

  Integer[] array = new Integer[10000];

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    array[key] = value;
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    Integer integer = array[key];
    return integer == null ? -1 : integer;


  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    array[key] = null;
  }


}
