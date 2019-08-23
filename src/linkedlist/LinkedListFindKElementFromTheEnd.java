package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListFindKElementFromTheEnd {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(7);
        list.add(8);

        int k = 2;
        System.out.println("K elm from the end is " + find(list, k) + " k = " + k);

    }

    static int find(LinkedList<Integer> list, int k) {

        Iterator<Integer> iterator = list.iterator();

        int size = 0;
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }

        Iterator<Integer> iterator2 = list.iterator();

        int lookingIndex = size - k;
        int i = 0;
        while (iterator2.hasNext()) {
            Integer elm = iterator2.next();
            if (i == lookingIndex) {
                return elm;
            }
            i++;
        }

        throw new RuntimeException("There is no elm k index from the end");
    }

}
