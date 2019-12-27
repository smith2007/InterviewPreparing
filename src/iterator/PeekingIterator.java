package iterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer curr = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            curr = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return curr;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = curr;
        if (iterator.hasNext()) {
            curr = iterator.next();
        } else {
            curr = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }
}