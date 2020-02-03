package data_structures;

import java.util.HashSet;
import java.util.Set;

public class DesignPhoneDirectory {

    public static void main(String[] args) {

    }

    private Set<Integer> pool = new HashSet<>();
    private int maxNumbers;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            pool.add(i);
        }

        this.maxNumbers = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (pool.isEmpty()){
            return -1;
        } else {
            Integer reserved = pool.iterator().next();
            pool.remove(reserved);
            return reserved;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return pool.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number>0 && number<=maxNumbers){
            pool.add(number);
        }
    }
}
