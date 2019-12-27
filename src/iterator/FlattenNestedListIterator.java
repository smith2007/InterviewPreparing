package iterator;

import java.util.Iterator;

public class FlattenNestedListIterator {

    public static <T> Iterator<T> flatten(Iterator<Iterator<T>> iterator) {


        return new Iterator<T>() {

            Iterator<T> curr = null;

            @Override
            public boolean hasNext() {
                if (curr == null) {
                    if (iterator.hasNext()) {
                        Iterator<T> newCurr = iterator.next();
                        while (newCurr.hasNext()) {
                            newCurr = iterator.next();
                            if (newCurr.hasNext()) {
                                curr = newCurr;
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    if (!curr.hasNext()) {
                        if (iterator.hasNext()) {
                            Iterator<T> newCurr = iterator.next();
                            while (newCurr.hasNext()) {
                                newCurr = iterator.next();
                                if (newCurr.hasNext()) {
                                    curr = newCurr;
                                    return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    return curr.next();
                }
                return null;
            }
        };
    }


}
